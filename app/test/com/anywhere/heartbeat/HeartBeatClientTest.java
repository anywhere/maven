package com.anywhere.heartbeat;

import org.junit.Test;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerUtils;
import org.quartz.impl.StdSchedulerFactory;

public class HeartBeatClientTest {
    
    @Test
    public void testRun() {
        try {
            new HeartBeatClientTest().startScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        try {
            new HeartBeatClientTest().startScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
    
    public void startScheduler() throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        JobDetail jobDetail = new JobDetail("HeartBeatClient", Scheduler.DEFAULT_GROUP, HeartBeatClient.class);
        jobDetail.getJobDataMap().put("name", "Collector");
        jobDetail.getJobDataMap().put("address", "192.168.0.22");
        jobDetail.getJobDataMap().put("port", 25535);
        jobDetail.getJobDataMap().put("interval", 2 * 1000);
        Trigger tigger = TriggerUtils.makeImmediateTrigger(0, 0);
        // makeSecondlyTrigger(1);
        tigger.setName(jobDetail.getName());
        scheduler.scheduleJob(jobDetail, tigger);
        scheduler.start();
        // scheduler.shutdown();
    }
}