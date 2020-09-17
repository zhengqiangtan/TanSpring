package com.project.tan.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author zhengqiang.tan
 * @Date 2020/9/17 5:11 PM
 * @Version 1.0
 */
@Component
public class SpringBeanUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        SpringBeanUtil.applicationContext = ac;
    }


    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }

    public static <T> T getBean(Class<T> beanName) {
        return applicationContext.getBean(beanName);
    }

    public static <T> Map<String, T> getAllImpl(Class<T> interfaceClass){
        //根据接口类型返回相应的所有bean
        return applicationContext.getBeansOfType(interfaceClass);
    }


}
