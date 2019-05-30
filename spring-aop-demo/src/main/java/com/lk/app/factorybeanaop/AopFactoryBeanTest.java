package com.lk.app.factorybeanaop;

import com.lk.app.factorybeanaop.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试半自动的FactoryBean方式实现aop
 *
 * @author LK
 * @date 2019/5/29
 */
public class AopFactoryBeanTest {

    @Test
    public void test() {
        String xmlPath = "factorybean.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        UserService userService = (UserService) applicationContext.getBean("proxyServiceId");

        userService.addUser();
        userService.updateUser();
        userService.deleteUser();
    }
}
