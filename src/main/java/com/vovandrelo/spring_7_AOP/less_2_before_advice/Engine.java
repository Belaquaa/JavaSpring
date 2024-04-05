package com.vovandrelo.spring_7_AOP.less_2_before_advice;

import org.springframework.stereotype.Component;
@Component
public class Engine {
    public void sound(String someSound) {
        System.out.println();
        System.out.println("Вызов основного метода:");
        System.out.println(someSound);
    }
}
