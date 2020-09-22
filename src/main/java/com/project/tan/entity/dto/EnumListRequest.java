package com.project.tan.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("EnumListRequest")
public class EnumListRequest implements Serializable {
    private static final long serialVersionUID = -2461121995550937155L;

    @ApiModelProperty(value = "枚举名请求列表")
    private List<String> enumList;

}
