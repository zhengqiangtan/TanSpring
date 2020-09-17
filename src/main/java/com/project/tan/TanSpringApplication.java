package com.project.tan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * 主启动类
 */
@EnableScheduling
@EnableAsync
@EnableCaching
@SpringBootApplication(scanBasePackages = "com.project.tan")
public class TanSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(TanSpringApplication.class, args);
    }
}
