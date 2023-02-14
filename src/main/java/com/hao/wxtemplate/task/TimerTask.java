package com.hao.wxtemplate.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimerTask {

    @Scheduled(cron = "0 49 16 * * ?")
    public void task() {
        System.out.println("定时任务...");
    }

}
