package com.vovandrelo.spring_7_AOP.less_3_after_returning_advice;

import org.springframework.stereotype.Component;

@Component
public class Person {
    public String getName() {
        return "Владимир";
    }
}
