package com.vincent.psringbootjdbcmultidatasoure.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig1 {


    @Bean(name = "one")
    @ConfigurationProperties(prefix = "spring.datasource.one")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }
}
