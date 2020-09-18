package com.project.tan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.tan.common.annotation.MyCacheable;
import com.project.tan.entity.dao.UserMapper;
import com.project.tan.entity.dto.BaseDTO;
import com.project.tan.entity.dto.UserDTO;
import com.project.tan.entity.model.User;
import com.project.tan.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 缓存配置实践
 * <p>
 * 缓存配置参考： https://www.cnblogs.com/yueguanguanyun/p/10826369.html
 *
 * @Cacheable 应用到读取数据的方法上，即可缓存的方法，如查找方法，先从缓存中读取，如果没有再调用相应方法获取数据，然后把数据添加到缓存中
 * - value 用于指定缓存存储的集合名
 * - key：缓存对象存储在Map集合中的key值，非必需，缺省按照函数的所有参数组合作为key值  @Cacheable(key = "#p0")
 * @CachePut 应用到写数据的方法上，如新增/修改方法，调用方法时会自动把相应的数据放入缓存
 * - @CacheEvict(value = "user", key = "#id")
 * @Caching 组合多个Cache注解使用
 */
@Slf4j
@Service
@CacheConfig(cacheNames = "user") // 主要用于配置该类中会用到的一些共用的缓存配置
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    //  @CachePut("users")  每次都会执行方法，并将结果存入指定的缓存中
    @Cacheable(key = "#id")
    @Override
    public UserDTO getUserById(Long id) {
        // User user =   userMapper.selectById(id);
        User user = userMapper.findUserById(id);
        UserDTO userDTO = UserDTO.builder().id(user.getId()).name(user.getName()).age(user.getAge()).email(user.getEmail()).build();
        return userDTO;
    }

    @Override
    @CachePut(key = "#userDTO.id")
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public void saveOrUpdate(UserDTO userDTO) {
        User user = User.builder().id(userDTO.getId()).name(userDTO.getName()).age(userDTO.getAge()).email(userDTO.getEmail()).build();
        if (userDTO.getId() == null) {
            userMapper.insert(user);
        } else {
            userMapper.updateById(user);
        }
    }

    @MyCacheable  // 自定义缓存注解
    @Override
    public IPage<User> getAll(BaseDTO baseDTO) {
        if (baseDTO.getPageNo() == null || baseDTO.getPageNo() == 0) {
            baseDTO.setPageNo(1);
        }
        if (baseDTO.getPageSize() == null || baseDTO.getPageSize() == 0) {
            baseDTO.setPageSize(10);
        }

        LambdaQueryWrapper<User> query = Wrappers.lambdaQuery();
        Page<User> page = new Page<>(baseDTO.getPageNo(), baseDTO.getPageSize());


        if (StringUtils.isNotBlank(baseDTO.getKeyword())) {
            query.like(User::getName, baseDTO.getKeyword())
                    .or().like(User::getAge, baseDTO.getKeyword())
                    .or().like(User::getEmail, baseDTO.getKeyword());
        }
        query.orderByDesc(User::getAge);
        Page<User> datasourcePage = userMapper.selectPage(page, query);
        return datasourcePage;

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = "user", key = "#id", allEntries = true, beforeInvocation = false)
    public void deleteById(Long id) {
        int cnt = userMapper.deleteUser(id);
        log.info("Delete User num is : {}", cnt);
    }
}

