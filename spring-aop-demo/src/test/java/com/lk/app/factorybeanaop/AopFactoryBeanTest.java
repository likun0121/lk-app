package com.lk.app.factorybeanaop;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author LK
 * @date 2019/6/6
 */
public class AopFactoryBeanTest {

    @Test
    public void run() {
        AopFactoryBean aopFactoryBean = new AopFactoryBean();
        aopFactoryBean.run();
    }
}