package com.project.tan.service.cacheing;

import com.project.tan.entity.model.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @Author zhengqiang.tan
 * @Date 2020/9/17 11:18 AM
 * @Version 1.0
 */
@Component
public class SimpleBookRepository implements BookRepository {

    /**
     * 加入缓存
     * @param isbn
     * @return
     */
    @Override
    @Cacheable("books")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    // 模拟耗时
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
