package com.project.tan.common.util;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 单例线程池
 */
public class ThreadPoolExecutorUtils {

    private ThreadPoolExecutorUtils() {
    }
    public static ThreadPoolExecutor getCommonExecutor() {
        return CommonExecutor.executor;
    }
    private static class CommonExecutor {
        private static ThreadPoolExecutor executor =
                new ThreadPoolExecutor(0, 10, 30, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(100),
                        new ThreadPoolExecutor.AbortPolicy());
    }

}
