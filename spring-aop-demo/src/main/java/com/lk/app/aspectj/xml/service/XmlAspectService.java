package com.lk.app.aspectj.xml.service;

/**
 * @author LK
 * @date 2019/6/6
 */
public interface XmlAspectService {

    /**
     * 被拦截的方法1
     */
    void doSomething();

    /**
     * 被拦截的方法2
     * @return
     */
    String again();
}
