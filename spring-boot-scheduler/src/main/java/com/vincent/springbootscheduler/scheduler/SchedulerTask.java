package com.vincent.springbootscheduler.scheduler;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {

    private int count = 0;

    /**
     * fixedRate = 2000 上一次开始执行时间点之后2秒再执行
     * fixedDelay = 2000 上一次执行完毕时间点之后2秒再执行
     * initialDelay = 2000 第一次初始化延迟2秒再执行
     */
    @Scheduled(fixedDelay = 6000)
    public void scheduler() {
        System.out.println("执行2秒");
    }

    @Scheduled(cron = "*/6 * * * * ?")
    private void process() {
        System.out.println("this is scheduler task runing  " + (count++));
    }

}
