package com.project.tan;

import com.project.tan.common.util.SpringBeanUtil;
import com.project.tan.entity.dao.UserMapper;
import com.project.tan.entity.model.User;
import com.project.tan.service.BaseService;
import com.project.tan.service.impl.MyService1;
import com.project.tan.service.impl.MyService2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 依据Service名来加载不同的实现类，实际工作中很有用
 *
 * @Author zhengqiang.tan
 * @Date 2020/9/16 10:01 AM
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBeanTest {

    @Test
    public void test() {
        BaseService baseService = (BaseService) SpringBeanUtil.getBean("MyService1");
        baseService.sayHi();

        BaseService baseService2 = (BaseService) SpringBeanUtil.getBean(MyService2.class);
        baseService2.sayHi();

    }
}

