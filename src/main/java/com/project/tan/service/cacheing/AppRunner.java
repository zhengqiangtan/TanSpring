package com.project.tan.service.cacheing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 功能：让自定义的代码业务在项目启动后再执行（一般是初始化一些东西，可以理解为开机启动）
 * - 实现 CommandLineRunner 接口
 * - 实现 ApplicationRunner 接口
 * <p>
 * 注意这里即使打上顺序标签也不一定OK，因为当其中一个Runner失败的时候可能会初始化失败，故按照线程独立开来。
 * <p>
 * https://spring.io/guides/gs/caching/
 *
 * @Author zhengqiang.tan
 * @Date 2020/9/17 11:24 AM
 * @Version 1.0
 */
@Slf4j
@Component
@Order(value = 2)
public class AppRunner implements CommandLineRunner {
    private final BookRepository bookRepository;
    public AppRunner(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * 注意：实现 CommandLineRunner 接口的业务代码如果出现异常，会影响项目启动主线程，从而导致项目启动失败，
     * 　　所以为了互相不影响，每个实现类里的业务代码都新开一个线程。
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {

        new Thread() {
            public void run() {
                log.info(".... Fetching books");
                log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
                log.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
                log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
                log.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
                log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
                log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
            }
        }.start();

    }
}
