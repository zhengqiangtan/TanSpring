package com.project.tan.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * 自定义监听器-监听请求
 *
 * @Author zhengqiang.tan
 * @Date 2020/9/21 11:31 AM
 * @Version 1.0
 */
@Slf4j
public class MyHttpRequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("request 监听器被销毁:{}", sre.toString());
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
        String requestURI = req.getRequestURI();
        log.info("{} 被调用！", requestURI);
    }
}
