//package com.project.tan.controller;
//
//import com.project.tan.entity.Result;
//import com.project.tan.entity.dto.ColumnDTO;
//import com.project.tan.entity.dto.DataSourceDTO;
//import com.project.tan.service.DataSourceService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("datasource")
//@Slf4j
//@Api(tags = "数据源相关接口")
//public class DatasourceController {
//
//    @Autowired
//    DataSourceService dataSourceService;
//
//    @PostMapping("getColumns")
//    @ApiOperation("获取mysql表的列信息含注释")
//    public Result<List<ColumnDTO>> getColumns(@RequestBody DataSourceDTO datasource) {
//        try {
//            return Result.successData(dataSourceService.getColumns(datasource));
//        } catch (Exception e) {
//            log.warn("save error: ", e);
//            return Result.errorMessage(e.getMessage());
//        }
//    }
//}
