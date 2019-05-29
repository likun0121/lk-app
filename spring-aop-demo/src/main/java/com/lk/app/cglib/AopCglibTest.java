package com.lk.app.cglib;

import com.lk.app.cglib.factory.MyBeanFactory;
import com.lk.app.cglib.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author LK
 * @date 2019/4/19
 */
public class AopCglibTest {

    @Test
    public void test1() {
        UserServiceImpl userService = MyBeanFactory.createService();
        userService.addUser();
        userService.updateUser();
        userService.deleteUser();
    }
}
