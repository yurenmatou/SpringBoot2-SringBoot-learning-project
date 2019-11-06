package com.vincent.springbootmultijpa.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 开机启动类，不指定Order注解情况下，仅次于ApplicationRunner后面执行
 */

@Component
public class MyCommonRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        //打印一行试试
        System.out.println("我就是我，不一样的烟火");
    }
}
