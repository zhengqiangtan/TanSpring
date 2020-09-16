package com.project.tan.service;

import com.project.tan.entity.dto.UserDTO;

public interface UserService {

    UserDTO getUserById(Long id);

    void saveOrUpdate(UserDTO userDTO);

}
