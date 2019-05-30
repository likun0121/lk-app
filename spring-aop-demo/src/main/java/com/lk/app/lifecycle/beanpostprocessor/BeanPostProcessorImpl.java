package com.lk.app.lifecycle.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;

/**
 * 后处理Bean实现
 *
 * @author LK
 * @date 2019/5/30
 */
public class BeanPostProcessorImpl implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("before init : " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("after init : " + beanName);
        return Proxy.newProxyInstance(BeanPostProcessorImpl.class.getClassLoader(),
                bean.getClass().getInterfaces(),
                (proxy, method, args) -> {

                    System.out.println("before invoke method");

                    Object o = method.invoke(bean, args);

                    System.out.println("after invoke method");

                    return o;
                });
    }
}
