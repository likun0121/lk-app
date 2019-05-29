package com.lk.app.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Cron表达式触发器方式调度
 *
 * @author LK
 * @date 2018/10/31
 */
public class CronSchedulerTest {

	public static void main(String[] args) {
		try {
			// 获取调度器Scheduler接口的实例
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();

			// 根据Job实例获取JobDetail
			JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
					.withIdentity("job2", "group2")
					.build();

			// 创建一个Cron表达式的触发器
			Trigger trigger = TriggerBuilder.newTrigger()
					.withIdentity("trigger2", "group2")
					.withSchedule(CronScheduleBuilder.cronSchedule("1/5 * * * * ?"))
					.build();

			// 将作业和触发器注册到调度器中
			scheduler.scheduleJob(jobDetail, trigger);

			scheduler.start();

//			scheduler.shutdown();

		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
