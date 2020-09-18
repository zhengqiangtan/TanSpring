package com.project.tan.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 配置文件
 *
 * @Author zhengqiang.tan
 * @Date 2020/9/18 3:00 PM
 * @Version 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "myconfig", ignoreInvalidFields = true, ignoreUnknownFields = true)
@Data
public class TanProperties {
    private RedisInfo redisInfo = new RedisInfo();
    private BaseArchTrackTopics baseArchTrackTopics = new BaseArchTrackTopics();

    /**
     * 开关白名单
     */
    private Boolean enableWhiteList;

    @Data
    public class RedisInfo {
        private String ip;
        private Integer port;
        private String password;
        private Integer database;
        private Integer maxTotal;
        private Integer minIdle;
        private Long maxWaitMillis;
    }

    @Data
    public class BaseArchTrackTopics {
        private String eventTopic;
        private String pageTopic;
        private String logTopic;
    }
}
