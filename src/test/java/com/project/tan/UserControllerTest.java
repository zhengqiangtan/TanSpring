package com.project.tan;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.project.tan.controller.UserController;
import com.project.tan.common.util.Result;
import com.project.tan.entity.dto.BaseDTO;
import com.project.tan.entity.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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


    @Test
    public void test2() throws Exception {
        BaseDTO baseDTO = new BaseDTO();
        baseDTO.setPageNo(1);
        baseDTO.setPageSize(5);
        baseDTO.setKeyword("Tan");
        Result<IPage<User>> allUser = userController.getAllUser(baseDTO);

        allUser.getData().getRecords().stream().forEach(l -> System.out.println(l.toString()));

    }
}
