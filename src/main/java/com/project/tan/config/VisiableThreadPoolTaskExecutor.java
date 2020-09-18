package com.project.tan.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 监视线程池执行情况
 * 任务总数、已完成数、活跃线程数，队列大小
 *
 * @Author zhengqiang.tan
 * @Date 2020/9/18 9:48 AM
 * @Version 1.0
 */
@Slf4j
public class VisiableThreadPoolTaskExecutor extends ThreadPoolTaskExecutor {
    private void showThreadPoolInfo(String prefix) {
        ThreadPoolExecutor threadPoolExecutor = getThreadPoolExecutor();

        if (null == threadPoolExecutor) {
            return;
        }

        log.info("ThreadPool State : {}, {},taskCount [{}], completedTaskCount [{}], activeCount [{}], queueSize [{}]",
                this.getThreadNamePrefix(),
                prefix,
                threadPoolExecutor.getTaskCount(),
                threadPoolExecutor.getCompletedTaskCount(),
                threadPoolExecutor.getActiveCount(),
                threadPoolExecutor.getQueue().size());
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        showThreadPoolInfo("submit task ...");
        return super.submit(task);
    }
}
