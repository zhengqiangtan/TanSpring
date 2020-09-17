package com.project.tan.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author zhengqiang.tan
 * @Date 2020/9/17 6:59 PM
 * @Version 1.0
 */
@Slf4j
@Component
public abstract class BaseService {

    public abstract void sayHi();

    public void print() {
        log.info("This is BaseService");
    }
}
