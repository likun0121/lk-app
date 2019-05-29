package com.lk.app.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author LK
 * @date 2018/11/5
 */
public class MyJobListener implements JobListener {

	private static Logger logger = LoggerFactory.getLogger(MyJobListener.class);

	@Override
	public String getName() {
		String name = this.getClass().getName();
		logger.info("拦截器名称: " + name);
		return name;
	}

	@Override
	public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
		logger.info("执行前");
	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {
		logger.info("执行被拦截");
	}

	@Override
	public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
		logger.info("执行完成了");
	}
}
