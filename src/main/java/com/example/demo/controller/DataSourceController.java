package com.example.demo.controller;

import com.example.demo.mapper.cluster.ClusterDataSourceMapper;
import com.example.demo.mapper.master.MasterDataSourceMapper;
import com.example.demo.service.IDataSourceService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringBoot配置支持主从库方案
 */
@RestController
public class DataSourceController {
    @Autowired
    private IDataSourceService dataSourceService;
    @Autowired
    private MasterDataSourceMapper masterDataSourceMapper;
    @Autowired
    private ClusterDataSourceMapper clusterDataSourceMapper;
    @RequestMapping("/")
    public String hello() throws Exception {
        return "Hello World!";
    }
    @RequestMapping("/getdatasourcelist")
    public String getDataSource() throws Exception {
        Gson gson = new Gson();
        return gson.toJson(dataSourceService.getDataSource());
    }
    @RequestMapping("/getmasterdatasourcelist")
    public String getMasterDataSourceList() {
        Gson gson = new Gson();
        return gson.toJson(masterDataSourceMapper.getDataSourceList());
    }
    @RequestMapping("/getclusterdatasourcelist")
    public String getClusterDataSourceList() {
        Gson gson = new Gson();
        return gson.toJson(clusterDataSourceMapper.getDataSourceList());
    }
}
