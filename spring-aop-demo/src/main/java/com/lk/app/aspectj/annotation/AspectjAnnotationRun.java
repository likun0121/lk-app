package com.lk.app.aspectj.annotation;

import com.lk.app.aspectj.annotation.service.AnnotationAspectService;
import com.lk.app.aspectj.xml.service.XmlAspectService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * aspectj的注解配置运行
 *
 * @author LK
 * @date 2019/6/6
 */
public class AspectjAnnotationRun {

    public void run() {
        String path = "aspectj-annotation.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
        AnnotationAspectService annotationAspectService = (AnnotationAspectService) applicationContext.getBean("serviceId");
        annotationAspectService.doSomething();
        annotationAspectService.again();
    }
}
