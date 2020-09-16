package com.project.tan.service.impl;

import com.project.tan.common.constant.DriverEnum;
import com.project.tan.entity.dto.ColumnDTO;
import com.project.tan.entity.dto.DataSourceDTO;
import com.project.tan.service.DataSourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class DataSourceServiceImpl implements DataSourceService {
    @Override
    public List<ColumnDTO> getColumns(DataSourceDTO datasourceDTO, String tableName) {
        if (DriverEnum.MYSQL.getDriver().equals(datasourceDTO.getDbType())) {
            return getMysqlColumns(datasourceDTO, tableName);
        }
        return Collections.emptyList();

    }


    /**
     * get mysql columns
     *
     * @param datasource
     * @param tableName
     */
    private List<ColumnDTO> getMysqlColumns(DataSourceDTO datasource, String tableName) {
        List<ColumnDTO> list = new ArrayList<>();
        String sql = "SELECT COLUMN_NAME, DATA_TYPE, COLUMN_COMMENT FROM information_schema.COLUMNS " +
                "WHERE TABLE_SCHEMA = '" + datasource.getDbName() + "' AND TABLE_NAME = '" + tableName + "'";
        try (Connection con = getMysqlConnection(datasource);
             PreparedStatement statement = con.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                ColumnDTO column = new ColumnDTO();
                column.setColumnName(resultSet.getString("COLUMN_NAME"));
                column.setColumnType(resultSet.getString("DATA_TYPE"));
                String columnComment = resultSet.getString("COLUMN_COMMENT");
                column.setColumnComment(columnComment != null ?
                        columnComment.replace("'", "") : "");
                list.add(column);
            }
        } catch (Exception e) {
            log.warn("getMysqlColumns error:", e);
        }
        return list;
    }

    private Connection getMysqlConnection(DataSourceDTO datasource) throws SQLException {
        return DriverManager.getConnection(datasource.getJdbcUrl(), datasource.getUserName(), datasource.getPassword());
    }
}
