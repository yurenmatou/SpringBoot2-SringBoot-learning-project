package com.vincent.springbootmybatismulidatasource;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.vincent.springbootmybatismulidatasource.mapper")
@SpringBootApplication
public class SpringBootMybatisMulidatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisMulidatasourceApplication.class, args);
    }

}
