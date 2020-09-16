package com.project.tan.service.impl;

import com.project.tan.entity.dao.UserMapper;
import com.project.tan.entity.dto.UserDTO;
import com.project.tan.entity.model.User;
import com.project.tan.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDTO getUserById(Long id) {
//        User user =   userMapper.selectById(id);
        User user = userMapper.findUserById(id);
        System.out.println("--->" + user.toString());
        UserDTO userDTO = UserDTO.builder().id(user.getId()).name(user.getName()).age(user.getAge()).email(user.getEmail()).build();


        return  userDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdate(UserDTO userDTO) {
        User user = User.builder().id(userDTO.getId()).name(userDTO.getName()).age(userDTO.getAge()).email(userDTO.getEmail()).build();
        if (userDTO.getId() == null) {
            userMapper.insert(user);
        } else {
            userMapper.updateById(user);
        }
    }
}
