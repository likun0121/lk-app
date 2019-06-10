package com.lk.app.aspectj.annotation;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author LK
 * @date 2019/6/10
 */
public class AspectjAnnotationRunTest {

    @Test
    public void run() {
        AspectjAnnotationRun aspectjAnnotationRun = new AspectjAnnotationRun();
        aspectjAnnotationRun.run();
    }
}