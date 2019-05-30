package com.lk.app.springaop.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 切面类（通知）
 *
 * @author LK
 * @date 2019/5/30
 */
public class Advices implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        System.out.println("before method invoke");

        Object obj = methodInvocation.proceed();

        System.out.println("after method invoke");

        return obj;
    }
}
