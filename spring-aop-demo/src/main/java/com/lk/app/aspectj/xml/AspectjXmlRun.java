package com.lk.app.aspectj.xml;

import com.lk.app.aspectj.service.TestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * aspectj的xml配置运行
 *
 * @author LK
 * @date 2019/6/6
 */
public class AspectjXmlRun {

    public void run() {
        String path = "aspectj.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
        TestService testService = (TestService) applicationContext.getBean("testServiceId");
        testService.doSomething();
        testService.again();
    }
}
