package com.belaquaa.spring_7_AOP.less_5_after_advice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Person person = context.getBean("person", Person.class);
        String someName = person.getName();
        System.out.println();
        System.out.println("Возвращённое значение: " + someName);

        context.close();
    }
}
