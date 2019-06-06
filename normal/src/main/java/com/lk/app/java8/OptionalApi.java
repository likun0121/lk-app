package com.lk.app.java8;

import org.junit.Test;

import java.util.Optional;

/**
 * 测试Optional
 *
 * @author LK
 * @date 2019/6/3
 */
public class OptionalApi {


    public void optionalMap() {
        A a = new A();
        Optional<B> optional = Optional.ofNullable(a.getB());
        B b = optional.map(e -> {
            e.setName("1");
            return e;
        }).orElse(new B());
        System.out.println(a);
        System.out.println(b);
    }

    class A {
        private String id;
        private B b;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public B getB() {
            return b;
        }

        public void setB(B b) {
            this.b = b;
        }

        @Override
        public String toString() {
            return "A{" +
                    "id='" + id + '\'' +
                    ", b=" + b +
                    '}';
        }
    }

    class B {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "B{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
