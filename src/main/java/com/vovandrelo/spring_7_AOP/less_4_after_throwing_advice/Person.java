package com.vovandrelo.spring_7_AOP.less_4_after_throwing_advice;

import org.springframework.stereotype.Component;

@Component
public class Person {
    public String getName() {
        throw new RuntimeException("Some exception text");
    }
}
