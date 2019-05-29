package com.lk.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LK
 * @date 2018/12/4
 */
public class Test {

	private static Pattern pattern = Pattern.compile("(.+)@.+(\\.com)");
	private static Pattern pattern1 = Pattern.compile("\\\\\\\\");

	public static void main(String[] args) {
		String s = "ab050246liuxiaoyu@ab-insurance.com";
		String ss = "\\";
		Matcher matcher = pattern.matcher(s);
		if (matcher.find()) {
			String s1 = matcher.group(1);
			System.out.println(s1);
			String s2 = matcher.group(2);
			System.out.println(s2);
		}

		Matcher matcher1 = pattern1.matcher(ss);
		System.out.println(matcher1.find());

	}
}
