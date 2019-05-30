package com.lk.app.springaop.service.impl;

import com.lk.app.springaop.service.AopService;

/**
 * @author LK
 * @date 2019/5/30
 */
public class AopServiceImpl implements AopService {

    @Override
    public void doSomething() {
        System.out.println("do something");
    }
}
