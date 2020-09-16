package com.project.tan.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel(description = "mysql表的列信息")
public class ColumnDTO {
    @ApiModelProperty("列名")
    private String columnName;
    @ApiModelProperty("列类型")
    private String columnType;
    @ApiModelProperty("列注释")
    private String columnComment;
}
