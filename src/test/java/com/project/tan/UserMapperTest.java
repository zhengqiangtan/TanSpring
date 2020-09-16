package com.project.tan;

import com.project.tan.entity.dao.UserMapper;
import com.project.tan.entity.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author zhengqiang.tan
 * @Date 2020/9/16 10:01 AM
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;


    @Test
    @Transactional(rollbackFor = Exception.class)
    public void test() {
        userMapper.insert("qqq", 22);
        User u = userMapper.findByName("qqq");
        Assert.assertEquals(22, u.getAge().intValue());
    }
}
