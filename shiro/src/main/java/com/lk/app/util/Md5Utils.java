package com.lk.app.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * md5加密工具
 *
 * @author LK
 * @date 2019/6/13
 */
public class Md5Utils {

    public static String md5Salt(String s, String salt) {
        return new Md5Hash(s, salt).toString();
    }

    public static String md5(String s) {
        return new Md5Hash(s).toString();
    }

    public static void main(String[] args) {
        String s = md5("123");
        System.out.println(s);
        String s1 = md5Salt("123", "Jack");
        System.out.println(s1);
    }
}
