package com.lk.app.lifecycle;

import com.lk.app.lifecycle.service.ProductService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试
 *
 * @author LK
 * @date 2019/5/30
 */
public class LifeCycleTest {

    @Test
    public void test() {
        String xmlPath = "lifecycle.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        ProductService productService = (ProductService) applicationContext.getBean("productServiceId");
        productService.addProduct();

        applicationContext.close();
    }
}
