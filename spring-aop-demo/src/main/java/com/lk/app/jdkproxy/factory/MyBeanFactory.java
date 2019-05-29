package com.lk.app.jdkproxy.factory;

import com.lk.app.jdkproxy.aspect.MyAspect;
import com.lk.app.jdkproxy.service.UserService;
import com.lk.app.jdkproxy.service.impl.UserServiceImpl;

import java.lang.reflect.Proxy;

/**
 * @author LK
 * @date 2019/4/19
 */
public class MyBeanFactory {

    public static UserService createService() {
        // 1.目标类
        UserServiceImpl userService = new UserServiceImpl();

        // 2.切面类
        MyAspect myAspect = new MyAspect();

        /* 3.代理类：将目标类（切入点）和切面类结合（通知）结合 --> 切面
         *
         */
        UserService proxyService = (UserService) Proxy.newProxyInstance(
                userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    myAspect.before();
                    Object obj = method.invoke(userService ,args);
                    myAspect.after();
                    return obj;
                });

        return proxyService;
    }
}
