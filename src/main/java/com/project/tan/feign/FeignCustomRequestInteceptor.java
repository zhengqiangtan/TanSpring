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
 * Fegin Config
 *
 * @Author zhengqiang.tan
 * @Date 2020/9/22 3:52 PM
 * @Version 1.0
 * 参考：https://www.cnblogs.com/taiyonghai/p/9306244.html
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
