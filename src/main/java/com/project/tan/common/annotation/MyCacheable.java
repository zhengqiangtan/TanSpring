package com.project.tan.common.annotation;

import org.springframework.cache.annotation.Cacheable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义可缓存注解
 * Spring允许我们在配置可缓存的方法时使用自定义的注解，前提是自定义的注解上必须使用对应的注解进行标注。
 *
 * @Author zhengqiang.tan
 * @Date 2020/9/18 2:14 PM
 * @Version 1.0
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Cacheable(value = "users")
public @interface MyCacheable {
}
