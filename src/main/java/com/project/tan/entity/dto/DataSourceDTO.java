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

    @ApiModelProperty("库名")
    private String dbType;

    @ApiModelProperty("库名")
    private String dbName;

    @ApiModelProperty("jdbcUrl")
    private String jdbcUrl;

    @ApiModelProperty("username")
    private String userName;

    @ApiModelProperty("password")
    private String password;

}