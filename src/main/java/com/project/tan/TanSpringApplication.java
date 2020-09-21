package com.project.tan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 主启动类
 *
 * @Author zhengqiang.tan
 * @Date 2020/9/15 8:34 PM
 * @Version 1.0
 */

//@EnableScheduling 定时任务开关
@EnableAsync
@EnableCaching
// 排除redis自动配置类（配合ConditionalOnProperty）
@SpringBootApplication(scanBasePackages = "com.project.tan", exclude = {RedisAutoConfiguration.class, RedisRepositoriesAutoConfiguration.class})
public class TanSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(TanSpringApplication.class, args);
    }
}
