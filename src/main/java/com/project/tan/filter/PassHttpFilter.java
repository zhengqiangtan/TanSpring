package com.project.tan.filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 方式三：通过filter 设置跨域
 * <p>
 * https://segmentfault.com/a/1190000020179829?utm_source=tag-newest
 *
 * @Author zhengqiang.tan
 * @Date 2020/9/22 10:39 AM
 * @Version 1.0
 */
@Component
@WebFilter(urlPatterns = "/*", filterName = "authFilter") //这里的“/*” 表示的是需要拦截的请求路径
public class PassHttpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.addHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8080"); // 允许该站点进行跨域访问
        filterChain.doFilter(servletRequest, httpResponse);
    }

    @Override
    public void destroy() {
    }
}