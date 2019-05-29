package com.lk.app;

import java.io.IOException;

/**
 * @author LK
 * @date 2018/12/4
 */
public interface InstanceDao {

	/**
	 * 持久化数据
	 *
	 * @param instance 任务实例
	 */
	void insert(TaskInstance instance) throws IOException;
}
