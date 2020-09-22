package com.project.tan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 过滤器、拦截器、监听器注册
 *
 * @Author zhengqiang.tan
 * @Date 2020/9/16 7:32 PM
 * @Version 1.0
 * @DESC RestTemplate是Spring提供的用于访问Rest服务的客户端，
 * RestTemplate提供了多种便捷访问远程Http服务的方法,能够大大提高客户端的编写效率。
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    // 暂时取消测试，不然每次测试都会输出很多log
//    @Autowired
//    MyInterceptor myInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(myInterceptor);
//    }
//
//
//    /**
//     * 注册过滤器
//     *
//     * @return
//     */
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
//        filterRegistration.setFilter(new MyFilter());
//        filterRegistration.addUrlPatterns("/*");
//        return filterRegistration;
//    }
//
//
//    /**
//     * 注册监听器
//     *
//     * @return
//     */
//    @Bean
//    public ServletListenerRegistrationBean registrationBean() {
//        ServletListenerRegistrationBean registrationBean = new ServletListenerRegistrationBean();
//        registrationBean.setListener(new MyHttpRequestListener());
//        registrationBean.setListener(new MyHttpSessionListener());
//        return registrationBean;
//    }


    /**
     * 方式二：全局配置跨域 示例
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(3600)
                .allowCredentials(true);
    }
}
