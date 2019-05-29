package com.lk.app.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Callable接口的测试类
 *
 * @author LK
 * @date 2018/11/29
 */
public class CallableTest {

	public static void main(String[] args) {
		List<Future<Integer>> list = new ArrayList<>();
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 20; i++) {
			MyTask task = new MyTask(i);
			Future<Integer> future = executorService.submit(task);
			list.add(future);
		}
		for (Future<Integer> future : list) {
			Integer i = null;
			try {
				i = future.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
}
