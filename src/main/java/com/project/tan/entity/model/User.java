package com.project.tan.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@ApiModel(description = "User实体类")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @ApiModelProperty(value = "用户id")
    private Long id;
    @ApiModelProperty(value = "username")
    private String name;
    @ApiModelProperty(value = "age")
    private Integer age;
    @ApiModelProperty(value = "email")
    private String email;
}
