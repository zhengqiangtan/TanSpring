package com.project.tan;

import com.project.tan.entity.model.User;
import com.project.tan.service.UserService2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author zhengqiang.tan
 * @Date 2020/9/15 8:39 PM
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService2 userService;


    @Before
    public void setUp() {
        // 准备，清空user表
        userService.deleteAllUsers();
    }


    @Test
    public void test() throws Exception {
        // 插入5个用户
        userService.create("Tom", 10, null);
        userService.create("Mike", 11, null);
        userService.create("Didispace", 30, null);
        userService.create("Oscar", 21, null);
        userService.create("Linda", 17, null);

        // 查询名为Oscar的用户，判断年龄是否匹配
        List<User> userList = userService.getByName("Oscar");
        Assert.assertEquals(21, userList.get(0).getAge().intValue());

        // 查数据库，应该有5个用户
        Assert.assertEquals(5, userService.getAllUsers());

        // 删除两个用户
        userService.deleteByName("Tom");
        userService.deleteByName("Mike");

        // 查数据库，应该有5个用户
        Assert.assertEquals(3, userService.getAllUsers());

    }


    @Test
    public void test2() {
        List<User> list = userService.getByName("aaa");
        list.stream().forEach(l -> System.out.println(l.toString()));

    }


}
