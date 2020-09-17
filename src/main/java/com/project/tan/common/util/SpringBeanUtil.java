package com.project.tan.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *
 * 功能：从已有的spring上下文取得已实例化的bean。通过ApplicationContextAware接口进行实现
 *
 * 当一个类实现了这个接口（ApplicationContextAware）之后，这个类就可以方便获得ApplicationContext中的所有bean。
 * 换句话说，就是这个类可以直接获取spring配置文件中，所有有引用到的bean对象。
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

    public static <T> T getBean(String beanName, Class<T> clazz) {
        return applicationContext.getBean(beanName, clazz);
    }

    public static <T> Map<String, T> getAllImpl(Class<T> interfaceClass){
        //根据接口类型返回相应的所有bean
        return applicationContext.getBeansOfType(interfaceClass);
    }


}
