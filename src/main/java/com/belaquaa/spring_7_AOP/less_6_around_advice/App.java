package com.belaquaa.spring_7_AOP.less_6_around_advice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Person person = context.getBean("person", Person.class);

        System.out.println("Возвращённое значение без вызова исключения: " + person.getName());
        System.out.println("Возвращённое значение с вызовом исключения: " + person.getNameWithThrow());

        context.close();
    }
}
