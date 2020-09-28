package com.project.tan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.tan.entity.dao.EmployeeMapper;
import com.project.tan.entity.model.Employee;
import com.project.tan.service.IEmployeeService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhengqiang.tan
 * @Date 2020/9/28 7:33 PM
 * @Version 1.0
 */
@Service
public class EmplyeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

    /**
     * 不分页模糊匹配
     *
     * @param keyword
     * @return
     */
    @Override
    public List<Employee> search(String keyword) {
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = Wrappers.lambdaQuery();
        lambdaQueryWrapper.like(Strings.isNotBlank(keyword), Employee::getName, keyword);
        List<Employee> list = this.list(lambdaQueryWrapper);
        return list;
    }
}
