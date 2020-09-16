package com.project.tan.service.impl;

import com.project.tan.entity.model.User;
import com.project.tan.service.UserService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 如何应用Spring中的JdbcTemplate来完成对MySQL的数据库读写操作
 * https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html
 *
 * @Author zhengqiang.tan
 * @Date 2020/9/15 8:35 PM
 * @Version 1.0
 */
@Service
public class UserServiceImpl2 implements UserService2 {

//    单数据源配置
//    private JdbcTemplate jdbcTemplate;


    @Autowired
    private JdbcTemplate primaryJdbcTemplate;


    @Override
    public int create(String name, Integer age) {
        return primaryJdbcTemplate.update("insert into USER(NAME, AGE) values(?, ?)", name, age);
    }

    @Override
    public List<User> getByName(String name) {
        List<User> users = primaryJdbcTemplate.query("select NAME, AGE from USER where NAME = ?", (resultSet, i) -> {
            User user = new User();
            user.setName(resultSet.getString("NAME"));
            user.setAge(resultSet.getInt("AGE"));
            return user;
        }, name);
        return users;
    }

    @Override
    public int deleteByName(String name) {
        return primaryJdbcTemplate.update("delete from USER where NAME = ?", name);
    }

    @Override
    public int getAllUsers() {
        return primaryJdbcTemplate.queryForObject("select count(1) from USER", Integer.class);
    }

    @Override
    public int deleteAllUsers() {
        return primaryJdbcTemplate.update("delete from USER");
    }
}
