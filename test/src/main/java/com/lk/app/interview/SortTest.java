package com.lk.app.interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author LK
 * @date 2019/4/2
 */
public class SortTest {

	/**
	 * 两个乒乓球队各3人，甲队a，b，c ，乙队x，y，z，
	 * b说不跟x、z比赛，a说不跟x比赛
	 */
	@Test
	public void test1() {
		for (char a = 'x'; a <= 'z'; a++) {
			for (char b = 'x'; b <= 'z'; b++) {
				if (a != b) {
					for (char c = 'x'; c <= 'z'; c++) {
						if (a != c && b != c) {
							if (a != 'x' && b != 'x' && b != 'z') {
								System.out.println("a vs " + a);
								System.out.println("b vs " + b);
								System.out.println("c vs " + c);
							}
						}
					}
				}
			}
		}
	}

	@Test
	public void test2() {
		int[] arr = {6, 3, 8, 2, 9, 1};
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

		}
		List<int[]> list = Arrays.asList(arr);
		System.out.println(list);
	}
}
