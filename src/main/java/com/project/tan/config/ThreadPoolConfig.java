package com.project.tan.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 功能：自定义线程池配置
 * <p>
 * 项目启动时会自动初始化好相应的线程池
 * <p>
 * 知识点回顾：四种线程池拒绝策略
 * <p>
 * 当线程池的任务缓存队列已满并且线程池中的线程数目达到maximumPoolSize时，如果还有任务到来就会采取任务拒绝策略，通常有以下四种策略：
 * ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
 * ThreadPoolExecutor.DiscardPolicy：丢弃任务，但是不抛出异常。
 * ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新提交被拒绝的任务
 * ThreadPoolExecutor.CallerRunsPolicy：由调用线程（提交任务的线程）处理该任务
 *
 * @Author zhengqiang.tan
 * @Date 2020/9/17 7:37 PM
 * @Version 1.0
 * @REF https://www.jianshu.com/p/9987905648d0,https://www.cnblogs.com/gaoyawei/p/7777254.html
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig {

    // 使用配置中的参数取值
    @Value("${thread.pool.core.size}")
    private int corePoolSize;

    /**
     * 定时任务执行线程池
     * @return
     */
    @Bean
    public Executor taskExecutor() {
        // ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 使用扩展线程池来展示当前线程池运行情况
        ThreadPoolTaskExecutor executor = new VisiableThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(50);
        executor.setQueueCapacity(200);
        executor.setKeepAliveSeconds(60);
        executor.setThreadNamePrefix("scheduleTask-");
        executor.setAwaitTerminationSeconds(60 * 5);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

}
