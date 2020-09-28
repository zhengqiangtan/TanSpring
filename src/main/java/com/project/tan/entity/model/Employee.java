package com.project.tan.entity.model;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 测试mybatis-plus注解
 *
 * 参考：
 * https://blog.csdn.net/qq_40241957/article/details/101772536
 * https://baomidou.com/guide/auto-fill-metainfo.html
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Employee对象", description = "测试")
@TableName("employee")
public class Employee implements Serializable {
    /**
     * value 指定主键列名，如和实体属性名一致可以省略不写
     * type 指定主键策略
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 新增属性 condition 预处理 WHERE 实体条件自定义运算规则
     */
    @TableField(condition = SqlCondition.LIKE)
    private String name;

    private Integer age;

    /**
     * 删除标示：0-未删除（默认），1-已删除
     */
    @TableLogic
    private Boolean deleted;

    //  添加非数据库字段
    @TableField(exist = false)
    private String note;

}
