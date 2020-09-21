package com.project.tan.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * 自定义过滤器
 *
 * @Author zhengqiang.tan
 * @Date 2020/9/21 11:16 AM
 * @Version 1.0
 * @REF https://mp.weixin.qq.com/s/k16AOko-EMcrASFLAHkc5Q
 */
@Slf4j
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化过滤器:MyFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) response);
        String requestUri = request.getRequestURI();
        log.info("请求地址是：" + requestUri);
        if (requestUri.contains("/addSession")
                || requestUri.contains("/removeSession")
                || requestUri.contains("/online")
                || requestUri.contains("/favicon.ico")) {
            filterChain.doFilter(servletRequest, response);
        } else {
            wrapper.sendRedirect("/online");
        }

    }

    @Override
    public void destroy() {
        log.info("销毁过滤器：MyFilter");
    }
}
