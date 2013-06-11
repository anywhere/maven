package com.unishine.nms.server.common.model.heartbeat;

import org.junit.Before;
import org.junit.Test;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerUtils;
import org.quartz.impl.StdSchedulerFactory;

import com.framework.ssm.server.heartbeat.HeartBeatServer;

public class HeartBeatServerTest {
    
    long PERIOD = 5 * 1000;// 5秒钟
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testRun() {
        try {
            new HeartBeatServerTest().startScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        try {
            new HeartBeatServerTest().startScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
    
    public void startScheduler() throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        JobDetail jobDetail = new JobDetail("HeartBeatServer", Scheduler.DEFAULT_GROUP, HeartBeatServer.class);
        // jobDetail.getJobDataMap().put("TASK-FIRST", "hello" + i);
        Trigger tigger = TriggerUtils.makeImmediateTrigger(0, 0);
        tigger.setName(jobDetail.getName());
        scheduler.scheduleJob(jobDetail, tigger);
        // scheduler.start();
        scheduler.startDelayed(5);
        // scheduler.shutdown();
    }
}