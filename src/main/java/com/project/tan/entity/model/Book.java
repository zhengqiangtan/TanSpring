package com.project.tan.entity.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 测试缓存
 * @Author zhengqiang.tan
 * @Date 2020/9/17 11:08 AM
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@ToString
@ApiModel("Book实体类")
public class Book {
    private String isbn;
    private String title;
}
