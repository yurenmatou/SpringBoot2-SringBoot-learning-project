package com.vincent.psringbootjdbcmultidatasoure.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcTemplateConfig {


    @Bean(name = "jdbcTemplate1")
    @Primary
    public JdbcTemplate jdbcTemplate1(@Qualifier("one") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "jdbcTemplate2")
    @Primary
    public JdbcTemplate jdbcTemplate2(@Qualifier("two") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
