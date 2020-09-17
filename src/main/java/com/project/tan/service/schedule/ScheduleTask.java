package com.project.tan.service.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 *
 * 使用场景：需要自动的去执行一些功能代码，比如定时发送心跳等操作。
 *
 * 定时任务演示:
 * 主要有3种方式设置执行周期：
 * cron表达式：最灵活的方式，可以根据表达式设定执行时间。
 * fixedRate：固定周期执行，执行周期 = max(fixedRate, 业务代码执行耗时)。
 * fixedDelay：上一次执行结束之后开始计时，执行周期 = fixedDelay + 业务代码执行耗时。
 *
 * @Author zhengqiang.tan
 * @Date 2020/9/17 7:31 PM
 * @Version 1.0
 */
@Slf4j
@Component
@Async
public class ScheduleTask {
    /**
     * cron表达式
     * 每3秒执行一次
     */
    @Scheduled(cron = "*/3 * * * * ?")
    public void run1() {
        log.info("====== 每3s打印一次 ======");
    }

    /**
     * 启动后10秒开始执行，固定5秒周期执行一次
     */
    @Scheduled(initialDelay = 10000, fixedRate = 5000)
    public void run2() {
        log.info("====== 启动后10秒开始执行，固定5秒周期执行一次 ======");
    }

    /**
     * 启动后10秒开始执行，距离上次执行结束之后20秒再开始执行下一次
     */
    @Scheduled(initialDelay = 10000, fixedDelay = 20000)
    public void run3() {
        log.info("====== 启动后10秒开始执行，距离上次执行结束之后20秒再开始执行下一次 ======");
    }
}
