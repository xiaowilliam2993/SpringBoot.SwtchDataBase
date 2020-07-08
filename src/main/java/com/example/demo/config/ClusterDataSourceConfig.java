package com.example.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.util.Map;

@Configuration
@MapperScan(basePackages = ClusterDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "clusterSqlSessionFactory")
@ConfigurationProperties(prefix = "cluster.datasource")
public class ClusterDataSourceConfig {
    public static final String PACKAGE = "com.example.demo.mapper.cluster";
    public static final String MAPPING_LOCATION = "classpath*:mapper/cluster/*.xml";

    private String url;
    private String username;
    private String password;
    private String driverClassName;
    private Map<String, String> tomcat;

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getDriverClassName() { return driverClassName; }
    public void setDriverClassName(String driverClassName) { this.driverClassName = driverClassName; }
    public Map<String, String> getTomcat() { return tomcat; }
    public void setTomcat(Map<String, String> tomcat) { this.tomcat = tomcat; }

    @Bean(name = "clusterDataSource")
    public DataSource clusterDataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setUrl(this.url);
        dataSource.setUsername(this.username);
        dataSource.setPassword(this.password);
        dataSource.setDriverClassName(this.driverClassName);
//        dataSource.setTestOnBorrow(Boolean.valueOf(tomcat.get("test-on-borrow") == null ? tomcat.get("testOnBorrow") : tomcat.get("test-on-borrow")));
//        dataSource.setValidationQuery(tomcat.get("validationQuery"));
        return dataSource;
    }

    @Bean(name = "clusterTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager() {
        return new DataSourceTransactionManager(clusterDataSource());
    }

    @Bean(name = "clusterSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("clusterDataSource") DataSource clusterDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(clusterDataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(ClusterDataSourceConfig.MAPPING_LOCATION));
        return sessionFactoryBean.getObject();
    }
}
