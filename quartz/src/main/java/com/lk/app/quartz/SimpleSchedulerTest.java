package com.lk.app.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;

/**
 * 关键类和接口说明：
 * Scheduler ：调度器，与调度程序交互的主要API
 * Job ：由希望由调度程序执行的组件实现的接口。（作业，执行的具体任务）
 * JobDetail ：用于定义作业的实例
 * Trigger ：触发器，定义执行给定作业的计划的组价
 * JobBuilder ：用于定义/构建JobDetail实例
 * TriggerBuilder ：用于定义/构建触发器实例
 *
 * @author LK
 * @date 2018/10/30
 */
public class SimpleSchedulerTest {

	public static void main(String[] args) {
		try {
			// 获得Scheduler实例
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();

			// 根据Job的实现类创建一个JobDetail实例
			JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
					.withIdentity("job1", "group1")
					.build();
			// 定义一个每3秒执行一次，共执行10次的的触发器
			Trigger trigger = TriggerBuilder.newTrigger().
					withIdentity("trigger1", "group1")
					.withSchedule(SimpleScheduleBuilder.simpleSchedule()
							.withIntervalInSeconds(3)
							.withRepeatCount(10))
					.build();

			// 将作业和触发器放入调度器中
			scheduler.scheduleJob(jobDetail, trigger);

			// 注册一个job监听
			scheduler.getListenerManager().addJobListener(new MyJobListener(), KeyMatcher.keyEquals(new JobKey("job1", "group1")));

			// 启动
			scheduler.start();
			// 关闭
//			scheduler.shutdown();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
