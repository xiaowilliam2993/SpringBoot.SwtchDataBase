package com.example.demo.mapper.cluster;

import com.example.demo.model.DataSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClusterDataSourceMapper {
    @Select("select DataSourceId as dataSourceId, " +
            "`Name` as `name`, " +
            "ifnull(GatewayId, '') as gatewayId, " +
            "ProjectId as projectId, " +
            "ifnull(`Connection`, '') as `connection`, " +
            "`Schema` as `schema` " +
            "from datasource " +
            "where `Type` = 0 and ProjectId is not null " +
            "limit 0,100")
    List<DataSource> getDataSourceList();
}
