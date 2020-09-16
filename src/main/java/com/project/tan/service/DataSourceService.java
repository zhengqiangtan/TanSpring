package com.project.tan.service;

import com.project.tan.entity.dto.ColumnDTO;
import com.project.tan.entity.dto.DataSourceDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DataSourceService {

    /**
     * 获取表下的所有列
     *
     * @param datasourceDTO
     * @return
     */
    List<ColumnDTO> getColumns(DataSourceDTO datasourceDTO);
}
