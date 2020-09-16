package com.project.tan.service;

import com.project.tan.entity.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author zhengqiang.tan
 * @Date 2020/9/15 8:34 PM
 * @Version 1.0
 */
public interface UserService2 {
    /**
     * 新增一个用户
     *
     * @param name
     * @param age
     */
    @Transactional(rollbackFor = Exception.class)
    int create(String name, Integer age, String email);

    /**
     * 根据name查询用户
     *
     * @param name
     * @return
     */
    List<User> getByName(String name);

    /**
     * 根据name删除用户
     *
     * @param name
     */
    @Transactional
    int deleteByName(String name);

    /**
     * 获取用户总量
     */
    int getAllUsers();

    /**
     * 删除所有用户
     */
    int deleteAllUsers();


}
