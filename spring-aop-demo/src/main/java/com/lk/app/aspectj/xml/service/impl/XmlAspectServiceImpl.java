package com.lk.app.aspectj.xml.service.impl;

import com.lk.app.aspectj.xml.service.XmlAspectService;

/**
 * @author LK
 * @date 2019/6/6
 */
public class XmlAspectServiceImpl implements XmlAspectService {

    @Override
    public void doSomething() {
        System.out.println("do something...");
    }

    @Override
    public String again() {
        System.out.println("again...");
//        int i = 1 / 0;
        return "again";
    }
}
