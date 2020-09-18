package com.project.tan.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.project.tan.common.util.Result;
import com.project.tan.entity.dto.BaseDTO;
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

    // Template风格
    @Autowired
    UserService2 userService2;


    @GetMapping("/id/{id}")
    @ApiOperation("根据id查询用户的接口-restful风格")
    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "1", required = true)
    public Result<UserDTO> getUserById(@PathVariable Long id) {
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

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除用户信息接口")
    public Result<String> deleteUserById(@PathVariable("id") Long id) {
        try {
            userService.deleteById(id);
        } catch (Exception e) {
            log.error("删除接口报错:{}", e.getMessage());
            return Result.errorMessage("删除用户发生错误！");
        }
        return Result.successMessage("删除成功！");
    }


    @GetMapping("/count")
    @ApiOperation("测试userService2--获取总数")
    public Result<Integer> getAllUsersCount() {
        int allUsersCnt = userService2.getAllUsers();
        return Result.successData(allUsersCnt);
    }

    @PostMapping("/create")
    @ApiOperation("测试userService2--更新用户信息接口")
    public Result<String> updateUserById2(@RequestBody UserDTO userDTO) {
        try {
            userService2.create(userDTO.getName(), userDTO.getAge(), userDTO.getEmail());
        } catch (Exception e) {
            return Result.errorMessage("测试userService2--创建用户信息接口");
        }
        return Result.successMessage("创建成功！");
    }


    @PostMapping("/all")
    @ApiOperation("测试userService--分页")
    public Result<IPage<User>> getAllUser(@RequestBody BaseDTO baseDTO) {
        try {

            IPage<User> all = userService.getAll(baseDTO);
            // 改变输出值 age 大小
            all.getRecords().forEach(sd -> sd.setAge(28));
            return Result.successData(all);

        } catch (Exception e) {
            return Result.errorMessage(e.getMessage());
        }

    }


}

