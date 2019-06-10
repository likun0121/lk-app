package com.lk.app.aspectj.annotation.service.impl;

import com.lk.app.aspectj.annotation.service.AnnotationAspectService;
import org.springframework.stereotype.Service;

/**
 * @author LK
 * @date 2019/6/10
 */
@Service("serviceId")
public class AnnotationAspectServiceImpl implements AnnotationAspectService {
    @Override
    public void doSomething() {
        System.out.println("do something ... by annotation");
    }

    @Override
    public String again() {
        System.out.println("again ... by annotation");
//        int i = 1 / 0;
        return "again";
    }
}
