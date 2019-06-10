package com.lk.app.aspectj.annotation.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 注解式切面类
 *
 * @author LK
 * @date 2019/6/10
 */
@Component
@Aspect
public class AnnotationAspectAdvices {

    /**
     * 自定义前置通知方法
     * 在@Before中使用切入点表达式，该表达式只对该方法生效
     *
     * @param joinPoint 连接点
     */
//    @Before("execution(* com.lk.app.aspectj.annotation.service.impl.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("before method : " + joinPoint.getSignature().getName());
    }

    /**
     * 声明公共的切入点表达式
     */
    @Pointcut("execution(* com.lk.app.aspectj.annotation.service.impl.*.*(..))")
    public void myPointcut() {
    }

    /**
     * 自定义后置通知方法
     * 在@AfterReturning注解中使用公共切入点表达式的引用，直接引用myPointcut方法
     *
     * @param joinPoint 连接点
     * @param obj       目标方法返回值
     */
//    @AfterReturning(value = "myPointcut()", returning = "obj")
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
    @Around("myPointcut()")
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
//    @AfterThrowing(value = "execution(* com.lk.app.aspectj.annotation.service.impl.*.*(..))", throwing = "e")
    public void afterThrowingAdvice(JoinPoint joinPoint, Throwable e) {
        System.out.println("throw exception : " + e.getMessage());
    }

    /**
     * 自定义最终通知方法
     *
     * @param joinPoint 连接点
     */
//    @After("myPointcut()")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("finally advice");
    }
}
