package com.lk.app.executor;

import java.util.concurrent.Callable;

/**
 * 具体任务类，通过Callable接口来实现
 *
 * @author LK
 * @date 2018/11/29
 */
public class MyTask implements Callable<Integer> {

	/**
	 * 任务名称，用于返回值
	 */
	private Integer num;

	public MyTask(Integer num) {
		this.num = num;
	}

	@Override
	public Integer call() throws Exception {
		Thread.sleep(1000);
		return num;
	}
}
