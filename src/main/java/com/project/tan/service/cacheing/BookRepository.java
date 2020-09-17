package com.project.tan.service.cacheing;

import com.project.tan.entity.model.Book;

/**
 * @Author zhengqiang.tan
 * @Date 2020/9/17 11:17 AM
 * @Version 1.0
 */
public interface BookRepository {

    Book getByIsbn(String isbn);

}