package com.example.demo.mapper.master;

import com.example.demo.model.DataSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.s ingframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MasterDataSourceMapper {
    @Select("SELECT DataSourceId AS dataSourceId, " +
            "Name AS name, " +
            "ProjectId AS projectId, " +
            "isnull(Connection, '') AS connection, " +
            "[Schema] AS [schema] " +
            "FROM DataSource " +
            "WHERE [Type] = 0 AND ProjectId IS NOT NULL")
    List<DataSource> getDataSourceList();
}
