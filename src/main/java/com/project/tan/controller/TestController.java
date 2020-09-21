package com.project.tan.controller;

import com.project.tan.filter.MyHttpSessionListener;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@Api(tags = "测试功能接口")
public class TestController {
    @GetMapping("hi")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    /**
     * 测试过滤器、拦截器、监听器的使用
     */
    @GetMapping("addSession")
    public String addSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("name", "zhengqiang");
        return "当前在线人数" + session.getServletContext().getAttribute("sessionCount") + "人";
    }

    @GetMapping("removeSession")
    public String removeSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "当前在线人数" + session.getServletContext().getAttribute("sessionCount") + "人";
    }

    @GetMapping("online")
    public String online() {
        return "当前在线人数" + MyHttpSessionListener.userCount.get() + "人";
    }

}
