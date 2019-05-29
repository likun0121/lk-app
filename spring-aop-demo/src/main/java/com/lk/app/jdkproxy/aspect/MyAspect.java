package com.lk.app.jdkproxy.aspect;

/**
 * @author LK
 * @date 2019/4/19
 */
public class MyAspect {

    public void before() {
        System.out.println("前方法");
    }

    public void after() {
        System.out.println("后方法");
    }
}
