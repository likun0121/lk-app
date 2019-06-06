package com.lk.app.jdkproxy;

import com.lk.app.jdkproxy.factory.MyBeanFactory;
import com.lk.app.jdkproxy.service.UserService;
import org.junit.Test;

/**
 * @author LK
 * @date 2019/4/19
 */
public class AopJdkProxy {

    public void run() {
        UserService userService = MyBeanFactory.createService();
        userService.addUser();
        userService.updateUser();
        userService.deleteUser();
    }
}
