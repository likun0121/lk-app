package com.lk.app.springaop;

import com.lk.app.springaop.service.AopService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试
 *
 * @author LK
 * @date 2019/5/30
 */
public class SpringAopTest {

    @Test
    public void test() {
        String xmlPath = "springaop.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        AopService aopService = (AopService) applicationContext.getBean("aopServiceId");

        aopService.doSomething();
    }
}
