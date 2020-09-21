package com.project.tan.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 自定义拦截器
 *
 * @Author zhengqiang.tan
 * @Date 2020/9/21 11:22 AM
 * @Version 1.0
 * <p>
 * preHandle：在 Controoler 处理请求之前被调用，返回值是 boolean类型，如果是true就进行下一步操作；若返回false，则证明不符合拦截条件，在失败的时候不会包含任何响应，此时需要调用对应的response返回对应响应。
 * <p>
 * postHandler：在 Controoler 处理请求执行完成后、生成视图前执行，可以通过ModelAndView对视图进行处理，当然ModelAndView也可以设置为 null。
 * <p>
 * afterCompletion：在 DispatcherServlet 完全处理请求后被调用，通常用于记录消耗时间，也可以对一些资源进行处理。
 */
@Slf4j
@Component
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("【MyInterceptor】调用了:{}", request.getRequestURI());
        request.setAttribute("requestTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        if (!request.getRequestURI().contains("/online")) {
            HttpSession session = request.getSession();
            String sessionName = (String) session.getAttribute("name");
            if ("haixiang".equals(sessionName)) {
                log.info("【MyInterceptor】当前浏览器存在 session:{}", sessionName);
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        long duration = (System.currentTimeMillis() - (Long) request.getAttribute("requestTime"));
        log.info("【MyInterceptor】[{}]调用耗时:{}ms", request.getRequestURI(), duration);
    }

}
