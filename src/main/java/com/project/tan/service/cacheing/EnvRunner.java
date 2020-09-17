package com.project.tan.service.cacheing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 测试--查询启动时打印启动环境名称
 *
 * @Author zhengqiang.tan
 * @Date 2020/9/17 8:18 PM
 * @Version 1.0
 */
@Slf4j
@Component
@Order(1)
public class EnvRunner implements CommandLineRunner {

    @Value("${env.name}")
    private String envName;

    @Override
    public void run(String... args) throws Exception {
        log.info("当前启动的环境是: {}", envName);
    }
}
