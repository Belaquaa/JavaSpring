package com.belaquaa.spring_7_AOP.less_4_after_throwing_advice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        try {
            Person person = context.getBean("person", Person.class);
            System.out.println(person.getName());
        } catch (RuntimeException exception) {
            System.out.println();
            System.out.println("Вызванное исключение: " + exception.getMessage());
        }

        context.close();
    }
}
