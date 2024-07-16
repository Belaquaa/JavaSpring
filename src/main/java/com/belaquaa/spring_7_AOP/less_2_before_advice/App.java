package com.belaquaa.spring_7_AOP.less_2_before_advice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Engine engine = context.getBean("engine", Engine.class);
        engine.sound("Custom sound: Wroom-wroom!");

        context.close();
    }
}
