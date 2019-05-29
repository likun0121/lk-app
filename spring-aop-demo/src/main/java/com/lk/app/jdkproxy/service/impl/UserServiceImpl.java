package com.lk.app.jdkproxy.service.impl;

import com.lk.app.jdkproxy.service.UserService;

/**
 * @author LK
 * @date 2019/4/19
 */
public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("addUser");
    }

    @Override
    public void updateUser() {
        System.out.println("updateUser");

    }

    @Override
    public void deleteUser() {
        System.out.println("deleteUser");

    }
}
