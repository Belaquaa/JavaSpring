package com.belaquaa.spring_7_AOP.less_6_around_advice;

import org.springframework.stereotype.Component;

@Component
public class Person {
    public String getName() {
        return "Владимир";
    }

    public String getNameWithThrow() {
        throw new RuntimeException("Some exception");
    }
}
