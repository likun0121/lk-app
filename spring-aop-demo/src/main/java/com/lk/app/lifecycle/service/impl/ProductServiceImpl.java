package com.lk.app.lifecycle.service.impl;

import com.lk.app.lifecycle.service.ProductService;

/**
 * 产品业务实现
 *
 * @author LK
 * @date 2019/5/30
 */
public class ProductServiceImpl implements ProductService {

    @Override
    public void addProduct() {
        System.out.println("add product");
    }

    private void init() {
        System.out.println("init");
    }

    private void destroy() {
        System.out.println("destroy");
    }
}
