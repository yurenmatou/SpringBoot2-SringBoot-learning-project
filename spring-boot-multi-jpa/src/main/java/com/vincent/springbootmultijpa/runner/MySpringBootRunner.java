package com.vincent.springbootmultijpa.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


/**
 * 不指定Order情况下，优先启动执行
 */
@Component
public class MySpringBootRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //打印一行试试
        System.out.println("我就是爱音乐，快叫我停下来");
    }
}
