package com.project.tan.service.impl;

import com.project.tan.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author zhengqiang.tan
 * @Date 2020/9/17 7:08 PM
 * @Version 1.0
 */
@Service("MyService2")
@Slf4j
public class MyService2 extends BaseService {
    @Override
    public void sayHi() {
       log.info("This is MyService2 say Hi !");
    }
}
