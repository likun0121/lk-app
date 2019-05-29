package com.lk.app.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * 作业类，Quartz 调度包的两个基本单元之一。
 * 通过实现 org.quartz.job 接口，可以使 Java 类变成可执行的
 *
 * @author LK
 * @date 2018/10/29
 */
public class MyJob implements Job {

	private static Logger logger = LoggerFactory.getLogger(MyJob.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("正在执行任务，触发器：" + context.getTrigger().getKey() +
				" ，作业：" + context.getJobDetail().getKey()
		);

	}
}
