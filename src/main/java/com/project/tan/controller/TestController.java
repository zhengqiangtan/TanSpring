package com.project.tan.controller;

import com.project.tan.filter.MyHttpSessionListener;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * TestController
 */
@CrossOrigin // 所有域名均可以访问该类下所有接口
//@CrossOrigin("https://blog.csdn.net") // 指定域名才可以访问如下的接口
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
