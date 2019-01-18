package com.feng.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by zhangyinglong on 2018/11/8.
 */
@Slf4j
//@Component
public class ScheduleTask {

    private int fixCount = 1;
    private int cronCount = 1;


    @Scheduled(fixedRate = 500L)
    public void testFixDelay(){
        log.info("testFxiDelay.........{}",fixCount++);
    }

    @Scheduled(cron = "10/10 * * * * *")
    public void testCron(){
        log.info("testCrone.........{}",cronCount++);
    }

}
