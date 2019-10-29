package com.vincent.springboothello;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootHelloApplication {

    /**
     * 启动的三种方法
     * 1、静态方法run
     * 2、new 一个对象初始化
     * 3、StringbootBuild构造
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootHelloApplication.class, args);

//        SpringApplication springBootApplication = new SpringApplication(SpringBootHelloApplication.class);
//        springBootApplication.setBannerMode(Banner.Mode.OFF);//关闭banner
//        springBootApplication.setWebApplicationType(WebApplicationType.NONE);//表示启动非web应用
//        springBootApplication.run(args);
//
//        new SpringApplicationBuilder(SpringBootHelloApplication.class).web(WebApplicationType.NONE).bannerMode(Banner.Mode.OFF).build().run(args);
    }

}
