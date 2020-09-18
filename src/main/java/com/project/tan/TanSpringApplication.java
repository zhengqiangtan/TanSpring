package com.project.tan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Map;


/**
 * 主启动类
 */
//@EnableScheduling 定时任务开关
@EnableCaching
@SpringBootApplication(scanBasePackages = "com.project.tan")
public class TanSpringApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(TanSpringApplication.class, args);
        ConfigurableEnvironment environment = run.getEnvironment();
        Map<String, Object> systemProperties = environment.getSystemProperties();
        for(Map.Entry<String,Object> map : systemProperties.entrySet()) {
            System.out.println(map.getKey()  + " : " + map.getValue());
        }
    }
}
