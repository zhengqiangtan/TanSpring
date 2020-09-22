package com.project.tan.feign;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

/**
 * 作用：微服务之前调用的时候请求不会传递参数，通过实现RequestInterceptor接口,完成对所有的Feign请求,传递请求头和请求参数。
 * 常见的使用时传递token。
 * apply方法往RequestTemplate添加自定义名称的header。
 * <p>
 * 参考：
 * https://zhuanlan.zhihu.com/p/81349317
 * https://blog.csdn.net/qq_35614141/article/details/88899805
 */

@Component
@Slf4j
public class FeignCustomRequestInteceptor implements RequestInterceptor {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void apply(RequestTemplate template) {
        if (HttpMethod.GET.toString() == template.method() && template.body() != null) {
            //feign 不支持GET方法传输POJO 转换成json，再换成query
            try {
                Map<String, Collection<String>> map = objectMapper.readValue(template.bodyTemplate(), new TypeReference<Map<String, Collection<String>>>() {

                });
                template.body();
                template.queries(map);
            } catch (IOException e) {
                log.error("cause exception", e);
            }
        }
    }
}
