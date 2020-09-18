package com.project.tan;

import com.project.tan.common.util.RedisUtils;
import com.project.tan.config.TanProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 依据Service名来加载不同的实现类，实际工作中很有用
 *
 * @Author zhengqiang.tan
 * @Date 2020/9/16 10:01 AM
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ReidsUtilTest {

    @Autowired
    private RedisUtils redisUtils;


    @Autowired
    private TanProperties tanProperties;

    @Test
    public void test() {

        log.info("redis ip = {}",this.tanProperties.getRedisInfo().getIp());

        redisUtils.set("phone","12345678");
        String phone = (String) redisUtils.get("phone");
        System.out.println("---->" + phone);

    }
}

