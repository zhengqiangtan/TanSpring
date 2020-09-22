package com.project.tan;

import com.project.tan.common.util.ThreadPoolExecutorUtils;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 单例线程池测试
 *
 * @Author zhengqiang.tan
 * @Date 2020/9/22 12:44 PM
 * @Version 1.0
 */
public class ThreadPoolTest {
    class MyThread implements Callable<String> {
        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        @Override
        public String call() {
            int sleepTime = new Random().nextInt(1000);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(name + " has been finished!");

            // 返回给调用者的值
            String str = name + " sleep time : " + sleepTime;
            return str;
        }
    }

    /**
     * 使用CompletionService来维护处理线程的返回结果时，主线程总是能够拿到最先完成的任务的返回值，而不管它们加入线程池的顺序。
     */
    public void testCompletionService() {
        // 1. 创建线程池
        ThreadPoolExecutor pool = ThreadPoolExecutorUtils.getCommonExecutor();
        CompletionService<String> completionService = new ExecutorCompletionService<String>(pool);


        // 2.添加任务
        for (int i = 0; i < 10; i++) {
            completionService.submit(new MyThread("Thread-" + i));
        }


        //注意：CompletionService里面有一个BlockingQueue 用来维护结果，如果不去取结果就会导致队列一直增长
        // CompletionService里的结果集，就是take出来的结果，不是先进先出原则，而是先完成先出
        for (int i = 0; i < 10; i++) {
            try {
                Future<String> take = completionService.take();// 原因：没有完成的任务会在这里阻塞
                System.out.println(take.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

        }

        // 3. 关闭线程池
        pool.shutdown();
    }


    /**
     * 自定义集合来实现获取线程池中任务的返回结果
     * 主线程并不能保证首先获得的是最先完成任务的线程返回值。它只是按加入线程池的顺序返回。
     *
     * @throws Exception
     */
    public void testByQueue() throws Exception {
        // 创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(10);
        BlockingQueue<Future<String>> queue = new LinkedBlockingQueue<Future<String>>();

        // 添加任务
        for (int i = 0; i < 10; i++) {
            Future<String> future = pool.submit(new MyThread("Thread-" + i));
            queue.add(future);
        }

        // 检查线程池任务执行结果
        for (int i = 0; i < 10; i++) {
            //take方法是阻塞方法，后面的任务完成了，前面的任务却没有完成，主程序就等待在那儿，只到前面的完成了它才知道原来后面的也完成
            System.out.println(queue.take().get());
        }

        // 关闭线程池
        pool.shutdown();
    }


    /**
     * 主方法测试程序
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ThreadPoolTest threadPoolTest = new ThreadPoolTest();
        threadPoolTest.testCompletionService();
        System.out.println("--------------------------------");
        threadPoolTest.testByQueue();
    }

}
