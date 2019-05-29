package com.lk.app.cglib.aspect;

/**
 * @author LK
 * @date 2019/4/19
 */
public class MyAspect {

    public void before() {
        System.out.println("cglib 前方法");
    }

    public void after() {
        System.out.println("cglib 后方法");
    }
}
