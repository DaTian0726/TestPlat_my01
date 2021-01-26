//package com.juhe.my01.task;
//
//import org.quartz.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class Task_Case {
//
//    @Bean
//    public JobDetail teatQuartzDetail() {
//        return JobBuilder.newJob(Task_Test.class).withIdentity("testQuartz").storeDurably().build();
//    }
//
//    @Bean
//    public Trigger testQuartzTrigger() {
//        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
//                .withIntervalInSeconds(300)  //设置时间周期单位秒
//                .repeatForever();
//        return TriggerBuilder.newTrigger().forJob(teatQuartzDetail())
//                .withIdentity("testQuartz")
//                .withSchedule(scheduleBuilder)
//                .build();
//    }
//}
