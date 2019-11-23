package com.vincent.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Map;


@Configuration
public class DataSourceConfig {


    /**
     * 需要
     * Jpa仓库配置
     * hibernate配置
     * vendor供应商Map返回参数的方法
     * 主库配置：属性名，@Primary，配置属性注解返回Datasource
     */
    @Autowired
    private JpaProperties jpaProperties;
    @Autowired
    private HibernateProperties hibernateProperties;

    @Bean(name = "primaryDataSource")
    @Primary
    @ConfigurationProperties("spring.datasource.primary")
    public DataSource firstDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondaryDataSource")
    @ConfigurationProperties("spring.datasource.secondary")
    public DataSource secondDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "threeDataSource")
    @ConfigurationProperties("spring.datasource.three")
    public DataSource threeDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "ddddd")
    @ConfigurationProperties("spring.datasource.ddddd")
    public DataSource ddddd() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "vendorProperties")
    public Map<String, Object> getVendorProperties() {
        return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
    }
}
