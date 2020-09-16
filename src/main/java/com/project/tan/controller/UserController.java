package com.project.tan.controller;

import com.project.tan.entity.Result;
import com.project.tan.entity.dto.UserDTO;
import com.project.tan.entity.model.User;
import com.project.tan.service.UserService;
import com.project.tan.service.UserService2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(tags = "用户管理相关接口")
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    UserService2 userService2;


    @GetMapping("/id/{id}")
    @ApiOperation("根据id查询用户的接口-restful风格")
    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "1", required = true)
    public Result<UserDTO> getUserById(@PathVariable Long id) {
        System.out.println("有没有收到变量？id=" + id);
        return Result.successData(userService.getUserById(id));
    }


    @PostMapping("/save")
    @ApiOperation("更新用户信息接口")
    public Result<String> updateUserById(@RequestBody UserDTO userDTO) {
        try {
            userService.saveOrUpdate(userDTO);
        } catch (Exception e) {
            log.error("更新用户接口报错:{}", e.getMessage());
            return Result.errorMessage("更新用户发生错误！");
        }
        return Result.successMessage("更新成功！");
    }



    @GetMapping("/count")
    @ApiOperation("测试userService2")
    public Result<Integer> getAllUsersCount() {
        int allUsersCnt = userService2.getAllUsers();
        return Result.successData(allUsersCnt);
    }



}

