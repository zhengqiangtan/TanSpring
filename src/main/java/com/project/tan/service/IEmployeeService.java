package com.project.tan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.tan.entity.model.Employee;

import java.util.List;

/**
 * @Author zhengqiang.tan
 * @Date 2020/9/28 7:31 PM
 * @Version 1.0
 */
public interface IEmployeeService extends IService<Employee> {
    List<Employee> search(String keyword);
}
