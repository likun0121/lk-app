package com.lk.app.aspectj.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面类，通知
 *
 * org.aspectj.lang.JoinPoint 可以使用getSignature方法，获取到方法签名，
 * 即方法的修饰符、返回值、方法名。JoinPoint也可以使用getArgs方法，获取到参数列表
 *
 * @author LK
 * @date 2019/6/6
 */
public class TestAdvices {

    /**
     * 自定义前置通知方法
     *
     * @param joinPoint 连接点
     */
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("before method : " + joinPoint.getSignature().getName());
    }

    /**
     * 自定义后置通知方法
     *
     * @param joinPoint 连接点
     * @param obj       目标方法返回值
     */
    public void afterReturningAdvice(JoinPoint joinPoint, Object obj) {
        System.out.println("after returning : " + joinPoint.getSignature().getName() + " ==> " + obj);
    }

    /**
     * 自定义环绕通知方法
     *
     * @param joinPoint 连接点
     * @return 目标方法执行结果
     * @throws Throwable
     */
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("before method invoke");

        // 手动执行目标方法
        Object object = joinPoint.proceed();

        System.out.println("after method invoke");

        return object;
    }

    /**
     * 自定义异常通知方法
     *
     * @param joinPoint 连接点
     * @param e         抛出的异常
     */
    public void afterThrowingAdvice(JoinPoint joinPoint, Throwable e) {
        System.out.println("throw exception : " + e.getMessage());
    }

    /**
     * 自定义最终通知方法
     *
     * @param joinPoint 连接点
     */
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("finally advice");
    }
}
