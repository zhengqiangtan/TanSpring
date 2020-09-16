package com.project.tan.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.project.tan.entity.dto.BaseDTO;
import com.project.tan.entity.dto.UserDTO;
import com.project.tan.entity.model.User;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

    /**
     * 指定ID查询User
     *
     * @param id
     * @return
     */
    UserDTO getUserById(Long id);

    /**
     * 增加事务管理
     *
     * @param userDTO
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    void saveOrUpdate(UserDTO userDTO);


    /**
     * 获取所有用户（列表页）
     *
     * @param baseDTO baseDTO
     * @return list
     */
    IPage<User> getAll(BaseDTO baseDTO);

}
