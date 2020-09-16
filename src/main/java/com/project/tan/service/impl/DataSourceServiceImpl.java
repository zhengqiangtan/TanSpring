package com.project.tan.service.impl;

import com.project.tan.common.constant.Constant;
import com.project.tan.common.exception.BizException;
import com.project.tan.entity.dto.ColumnDTO;
import com.project.tan.entity.dto.DataSourceDTO;
import com.project.tan.service.DataSourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class DataSourceServiceImpl implements DataSourceService {
    @Override
    public List<ColumnDTO> getColumns(DataSourceDTO datasourceDTO) {
        return null;
    }



    /**
     * get mysql columns
     *
     * @param datasource
     * @param tableName
     */
//    private List<ColumnDTO> getMysqlColumns(SyncDatasource datasource, String tableName) {
//        List<ColumnDTO> list = new ArrayList<>();
//        String sql = "SELECT COLUMN_NAME, DATA_TYPE, COLUMN_COMMENT FROM information_schema.COLUMNS " +
//                "WHERE TABLE_SCHEMA = '" + datasource.getDbName() + "' AND TABLE_NAME = '" + tableName + "'";
//        try (Connection con = getMysqlConnection(datasource);
//             PreparedStatement statement = con.prepareStatement(sql);
//             ResultSet resultSet = statement.executeQuery()) {
//            while (resultSet.next()) {
//                ColumnDTO column = new ColumnDTO();
//                column.setColumnName(resultSet.getString("COLUMN_NAME"));
//                column.setColumnType(resultSet.getString("DATA_TYPE"));
//                // 可能业务库注释有问题，特殊处理"'"号
//                String columnComment = resultSet.getString("COLUMN_COMMENT");
//                column.setColumnComment(columnComment != null ?
//                        columnComment.replace("'", "") : "");
//                list.add(column);
//            }
//        } catch (Exception e) {
//            log.warn("getMysqlColumns error:", e);
//        }
//        return list;
//    }
}
