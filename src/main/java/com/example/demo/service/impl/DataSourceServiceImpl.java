package com.example.demo.service.impl;

import com.example.demo.dao.DataSourceDao;
import com.example.demo.service.IDataSourceService;
import org.springframework.beans.factory.annotation utowired;
import org.springframework.stereotype.Service;

@Service
public class DataSourceServiceImpl implements IDataSourceService {
    @Autowired
    private DataSourceDao dao;
    @Override
    public Object getDataSource() throws Exception {
//        return dao.getDataSource();
        return null;
    }
}
