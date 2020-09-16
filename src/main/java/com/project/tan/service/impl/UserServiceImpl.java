package com.project.tan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.tan.entity.dao.UserMapper;
import com.project.tan.entity.dto.BaseDTO;
import com.project.tan.entity.dto.UserDTO;
import com.project.tan.entity.model.User;
import com.project.tan.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDTO getUserById(Long id) {
//        User user =   userMapper.selectById(id);
        User user = userMapper.findUserById(id);
        UserDTO userDTO = UserDTO.builder().id(user.getId()).name(user.getName()).age(user.getAge()).email(user.getEmail()).build();
        return userDTO;
    }

    @Override
    public void saveOrUpdate(UserDTO userDTO) {
        User user = User.builder().id(userDTO.getId()).name(userDTO.getName()).age(userDTO.getAge()).email(userDTO.getEmail()).build();
        if (userDTO.getId() == null) {
            userMapper.insert(user);
        } else {
            userMapper.updateById(user);
        }
    }

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
}
