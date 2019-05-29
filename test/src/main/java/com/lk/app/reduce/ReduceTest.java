package com.lk.app.reduce;

import java.util.stream.Stream;

/**
 * @author LK
 * @date 2019/5/28
 */
public class ReduceTest {

    public static void main(String[] args) {
        System.out.println(Stream.of(1, 2, 3).parallel().reduce(4, (s1, s2) -> s1 + s2
                , (s1, s2) -> s1 + s2));
    }
}
