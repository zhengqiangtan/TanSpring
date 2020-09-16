package com.project.tan.entity.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.NonNull;

/**
 * @Author zhengqiang.tan
 * @Date 2020/9/15 5:23 PM
 * @Version 1.0
 */
public class Student {

    @ApiModelProperty("姓名")
//    @Size(max = 20)
    private String name;


    @ApiModelProperty("年龄")
//    @Max(150)
//    @Min(1)
    private Integer age;

    @NonNull
    private String address;

//    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")
    private String email;

}