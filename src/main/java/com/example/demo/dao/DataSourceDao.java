package com.example.demo.dao;

import com.example.demo.model.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DataSourceDao {
//    @Resource
//    private JdbcTemplate template;
//    public List<DataSource> getDataSource() {
//        return template.query(
//                "select DataSourceId as dataSourceId, " +
//                        "Name as name, " +
//                        "ProjectId as projectId, " +
//                        "isnull(Connection, '') as connection, " +
//                        "[Schema] as [schema] " +
//                        "from DataSource " +
//                        "where [Type] = 0 and ProjectId is not null",
//                /* "mysql scripte
//                "select DataSourceId as dataSourceId, " +
//                "`Name` as `name`, " +
//                "ifnull(GatewayId, '') as gatewayId, " +
//                "ProjectId as projectId, " +
//                "ifnull(`Connection`, '') as `connection`, " +
//                "`Schema` as `schema` " +
//                "from datasource " +
//                "where `Type` = 0 and ProjectId is not null limit 0,100",
//                */
//                new RowMapper<DataSource>() {
//            DataSource dataSource = null;
//            @Override
//            public DataSource mapRow(ResultSet resultSet, int i) throws SQLException {
//                dataSource = new DataSource();
//                dataSource.setDataSourceId(resultSet.getString("dataSourceId"));
//                dataSource.setName(resultSet.getString("name"));
////                dataSource.setGatewayId(resultSet.getString("gatewayId"));
//                dataSource.setProjectId(resultSet.getString("projectId"));
//                dataSource.setConnection(resultSet.getString("connection"));
//                dataSource.setSchema(resultSet.getString("schema"));
//                return dataSource;
//            }
//        });
//    }
}
