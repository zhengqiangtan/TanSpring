package com.project.tan.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "用户相关")
@ToString
public class UserDTO {
    @ApiModelProperty("用户ID")
    private Long id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("年龄")
    private int age;

    @ApiModelProperty("邮件")
    private String email;
}
