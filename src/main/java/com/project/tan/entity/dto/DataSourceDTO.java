package com.project.tan.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "数据源相关")
public class DataSourceDTO {

    @ApiModelProperty("数据源ID")
    private Long id;

    @ApiModelProperty("表名")
    private String tableName;
}