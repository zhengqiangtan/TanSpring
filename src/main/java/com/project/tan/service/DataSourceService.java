package com.project.tan.service;

import com.project.tan.entity.dto.ColumnDTO;
import com.project.tan.entity.dto.DataSourceDTO;

import java.util.List;

public interface DataSourceService {

    /**
     * 获取表下的所有列
     *
     * @param datasourceDTO
     * @return
     */
    List<ColumnDTO> getColumns(DataSourceDTO datasourceDTO, String tableName);
}
