package com.project.tan;

import com.project.tan.controller.UserController;
import com.project.tan.entity.Result;
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
 * UserControllerTest
 *
 * @Author zhengqiang.tan
 * @Date 2020/9/15 8:39 PM
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Before
    public void setUp() {
    }

    @Test
    public void test() throws Exception {
        Result<Integer> allUsersCount = userController.getAllUsersCount();
        // 查数据库，应该有2个用户
        Assert.assertEquals(2, allUsersCount.getData().intValue());

    }
}
