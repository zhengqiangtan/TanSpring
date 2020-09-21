//package com.project.tan.common.util;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.data.redis.core.RedisCallback;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Component;
//import redis.clients.jedis.Jedis;
//
//import java.io.Serializable;
//import java.util.*;
//import java.util.concurrent.TimeUnit;
//
//@Component
//public class RedisUtils {
//
//    private static final Long RELEASE_SUCCESS = 1L;
//    private static final String LOCK_SUCCESS = "OK";
//    private static final String SET_IF_NOT_EXIST = "NX";
//    private static final String SET_WITH_EXPIRE_TIME = "EX";
//    private static final String RELEASE_LOCK_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
//
//    @Autowired
//    @Qualifier("redisTemplate")
//    private RedisTemplate redisTemplate;
//
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//    /**
//     * 批量删除对应的value
//     *
//     * @param keys
//     */
//    public void remove(final String... keys) {
//        for (String key : keys) {
//            remove(key);
//        }
//    }
//
//    /**
//     * 批量删除key
//     *
//     * @param pattern
//     */
//    public void removePattern(final String pattern) {
//        Set<Serializable> keys = redisTemplate.keys(pattern);
//        if (keys.size() > 0) {
//            redisTemplate.delete(keys);
//        }
//    }
//
//    /**
//     * 删除对应的value
//     *
//     * @param key
//     */
//    public void remove(final String key) {
//        if (exists(key)) {
//            redisTemplate.delete(key);
//        }
//    }
//
//    /**
//     * 判断缓存中是否有对应的value
//     *
//     * @param key
//     * @return
//     */
//    public boolean exists(final String key) {
//        return redisTemplate.hasKey(key);
//    }
//
//    /**
//     * 读取缓存
//     *
//     * @param key
//     * @return
//     */
//    public Object get(final String key) {
//        return redisTemplate.opsForValue().get(key);
//    }
//
//    /**
//     * 批量读取读取缓存
//     *
//     * @param keys
//     * @return
//     */
//    public List multiGet(final Collection keys) {
//        return redisTemplate.opsForValue().multiGet(keys);
//    }
//
//    /**
//     * 写入缓存
//     *
//     * @param key
//     * @param value
//     * @return
//     */
//    public void set(final String key, Object value, Long expireTime) {
//        redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
//    }
//
//    /**
//     * 写入缓存
//     *
//     * @param key
//     * @param value
//     * @return
//     */
//    public void set(final String key, Object value) {
//        redisTemplate.opsForValue().set(key, value);
//    }
//
//    /**
//     * 删除
//     *
//     * @param key
//     */
//    public void delete(final String key) {
//        redisTemplate.delete(key);
//    }
//
//    /**
//     * 获取hash键
//     *
//     * @param key
//     */
//    public Set keys(final String key) {
//        return redisTemplate.opsForHash().keys(key);
//    }
//
//
//    /**
//     * 获取hash值集合
//     *
//     * @param key
//     */
//    public Object get(final String key, final String hashKey) {
//        return redisTemplate.opsForHash().get(key, hashKey);
//    }
//
//    /**
//     * 获取hash值集合
//     *
//     * @param key
//     */
//    public List multiGet(final String key, final Collection hashKeys) {
//        return redisTemplate.opsForHash().multiGet(key, hashKeys);
//    }
//
//    /**
//     * 获取hashEntry值集合
//     *
//     * @param key
//     */
//    public Map entries(final String key) {
//        return redisTemplate.opsForHash().entries(key);
//    }
//
//    public void put(final String key, final String hashKey, final Object hashValue) {
//        redisTemplate.opsForHash().put(key, hashKey, hashValue);
//    }
//
//    public void putAll(final String key, final Map map) {
//        redisTemplate.opsForHash().putAll(key, map);
//    }
//
//    /**
//     * 设置键的过期时间
//     *
//     * @param key
//     * @param timeout
//     * @param unit
//     * @return
//     */
//    public Boolean expire(final String key, final long timeout, final TimeUnit unit) {
//        return redisTemplate.expire(key, timeout, unit);
//    }
//
//    /**
//     * 该加锁方法仅针对单实例 Redis 可实现分布式加锁
//     * 对于 Redis 集群则无法使用
//     * <p>
//     * 支持重复，线程安全(但是不会循环去获取锁)
//     *
//     * @param lockKey  加锁键
//     * @param clientId 加锁客户端唯一标识(采用UUID)
//     * @param seconds  锁过期时间
//     * @return
//     */
////    public Boolean tryLock(String lockKey, String clientId, long seconds) {
////        return stringRedisTemplate.execute((RedisCallback<Boolean>) redisConnection -> {
////            Jedis jedis = (Jedis) redisConnection.getNativeConnection();
////            String result = jedis.set(lockKey, clientId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, seconds);
////            if (LOCK_SUCCESS.equals(result)) {
////                return Boolean.TRUE;
////            }
////            return Boolean.FALSE;
////        });
////    }
//
//    /**
//     * 与 tryLock 相对应，用作释放锁
//     *
//     * @param lockKey
//     * @param clientId
//     * @return
//     */
//    public Boolean releaseLock(String lockKey, String clientId) {
//        return stringRedisTemplate.execute((RedisCallback<Boolean>) redisConnection -> {
//            Jedis jedis = (Jedis) redisConnection.getNativeConnection();
//            Object result = jedis.eval(RELEASE_LOCK_SCRIPT, Collections.singletonList(lockKey),
//                    Collections.singletonList(clientId));
//            if (RELEASE_SUCCESS.equals(result)) {
//                return Boolean.TRUE;
//            }
//            return Boolean.FALSE;
//        });
//    }
//
//    /**
//     * 进行zset的操作
//     *
//     * @param key   key
//     * @param value value
//     * @param score score
//     * @return
//     */
//    public Double zadd(String key, String value, double score) {
//        Double result = redisTemplate.opsForZSet().incrementScore(key, value, score);
//        return result;
//    }
//
//    /**
//     * 获取zset中的topN值
//     *
//     * @param key  key
//     * @param topN topN
//     * @return
//     */
//    public Set getzTopN(String key, Integer topN) {
//        Set range = redisTemplate.opsForZSet().reverseRange(key, 0, topN - 1);
//        return range;
//    }
//
//    /**
//     * 将数据从左边push到list中
//     *
//     * @param key    key
//     * @param object value
//     */
//    public void lpush(String key, String object, long size) {
//        redisTemplate.opsForList().remove(key, size, object);
//        redisTemplate.opsForList().leftPush(key, object);
//    }
//
//    /**
//     * 获取从左边开始的size条数据
//     *
//     * @param key  key
//     * @param size size
//     * @return result
//     */
//    public List lRangeWithTrimWithRem(String key, Integer size) {
//        redisTemplate.opsForList().trim(key, 0, size - 1);
//        List result = redisTemplate.opsForList().range(key, 0, size - 1);
//        return result;
//    }
//}
