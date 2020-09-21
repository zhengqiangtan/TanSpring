package com.project.tan.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author zhengqiang.tan
 * @Date 2020/9/18 2:58 PM
 * @Version 1.0
 */
// 启用条件：当配置文件中myconfig.redis=redis才会生效，否则不启用
@ConditionalOnProperty(name = "myconfig.redis", havingValue = "redis",matchIfMissing = true)
@Configuration
@Slf4j
public class RedisConfig {
    @Autowired
    private TanProperties tanProperties;

    public RedisConfig() {
    }

    @Bean(
            name = {"jedisPoolConfig"}
    )
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(this.tanProperties.getRedisInfo().getMaxTotal());
        jedisPoolConfig.setMinIdle(this.tanProperties.getRedisInfo().getMinIdle());
        jedisPoolConfig.setMaxWaitMillis(this.tanProperties.getRedisInfo().getMaxWaitMillis());
        return jedisPoolConfig;
    }

    @Bean(
            name = {"redisConnectionFactory"}
    )
    public RedisConnectionFactory redisConnectionFactory() {
        log.info("redis info ip=: {}" ,this.tanProperties.getRedisInfo().getIp());
        return this.connectionFactory(this.tanProperties.getRedisInfo().getIp(), this.tanProperties.getRedisInfo().getPort(), this.tanProperties.getRedisInfo().getPassword(), this.tanProperties.getRedisInfo().getDatabase());
    }

    public RedisConnectionFactory connectionFactory(String hostName, int port, String password, int index) {
        JedisConnectionFactory jedis = new JedisConnectionFactory();

        jedis.setHostName(hostName);
        jedis.setPort(port);
        if (!StringUtils.isEmpty(password)) {
            jedis.setPassword(password);
        }

        if (index != 0) {
            jedis.setDatabase(index);
        }

        jedis.setPoolConfig(this.jedisPoolConfig());
        jedis.afterPropertiesSet();
        return jedis;
    }

    @Bean({"redisTemplate"})
    public RedisTemplate redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(this.redisConnectionFactory());
        this.setSerializer(redisTemplate);
        return redisTemplate;
    }

    private void setSerializer(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        redisTemplate.afterPropertiesSet();
    }
}
