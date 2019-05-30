package com.lk.app.factorybeanaop.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 切面类
 *
 * @author LK
 * @date 2019/5/29
 */
public class FactoryBeanAspect implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        System.out.println("执行前");

        Object obj = methodInvocation.proceed();

        System.out.println("执行后");

        return obj;
    }
}
