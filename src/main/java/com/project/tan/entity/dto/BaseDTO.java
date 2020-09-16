package com.project.tan.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author zhengqiang.tan
 * @Date 2020/9/16 4:18 PM
 * @Version 1.0
 */
@Setter
@Getter
@ApiModel(description = "分页入参基类")
public class BaseDTO {

    @ApiModelProperty("模糊搜索关键词")
    private String keyword;

    @ApiModelProperty("分页当前页")
    private Integer pageNo;

    @ApiModelProperty("分页大小")
    private Integer pageSize;
}

