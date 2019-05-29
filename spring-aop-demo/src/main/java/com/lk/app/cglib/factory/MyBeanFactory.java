package com.lk.app.cglib.factory;

import com.lk.app.cglib.aspect.MyAspect;
import com.lk.app.cglib.service.impl.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author LK
 * @date 2019/4/19
 */
public class MyBeanFactory {

    public static UserServiceImpl createService() {
        // 1.目标类
        UserServiceImpl userService = new UserServiceImpl();

        // 2.切面类
        MyAspect myAspect = new MyAspect();

        /* 3.代理类 采用cglib，底层创建目标类的子类
         *
         */
        // 3.1 核心类
        Enhancer enhancer = new Enhancer();
        // 3.2 确定父类
        enhancer.setSuperclass(userService.getClass());
        // 3.3 设置回调函数，此接口等效jdk InvocationHandler
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            myAspect.before();
            Object obj = method.invoke(userService, objects);
            // 执行代理类的父类，即执行目标类（目标类和代理类是父子关系）
            methodProxy.invokeSuper(o, objects);
            myAspect.after();
            return obj;
        });
        // 3.4 创建代理类
        UserServiceImpl proxyService = (UserServiceImpl) enhancer.create();

        return proxyService;
    }
}
