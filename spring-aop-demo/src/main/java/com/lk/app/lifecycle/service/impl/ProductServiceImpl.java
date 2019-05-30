package com.lk.app.lifecycle.service.impl;

import com.lk.app.lifecycle.service.UserService;

/**
 * 用户业务实现
 *
 * @author LK
 * @date 2019/5/30
 */
public class UserServiceImpl implements UserService {

    @Override
    public void addUser() {
        System.out.println("add user");
    }

    private void init() {
        System.out.println("init");
    }

    private void destroy() {
        System.out.println("destroy");
    }
}
