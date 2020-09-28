package com.project.tan.entity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.tan.entity.model.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author zhengqiang.tan
 * @Date 2020/9/28 7:30 PM
 * @Version 1.0
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
