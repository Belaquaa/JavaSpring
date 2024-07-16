package com.belaquaa.spring_2_configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Создание Spring-Container-а:
        ApplicationContext springContainer = new AnnotationConfigApplicationContext(Config.class);

        // Извлечение bean-а somePet:
        Pet somePet = springContainer.getBean("somePet", Pet.class);
        System.out.println("Извлечённый bean класса Pet:");
        System.out.println(somePet.getName());

        // Извлечение bean-а somePerson:
        Person somePerson = springContainer.getBean("somePerson", Person.class);
        System.out.println("Извлечённый bean класса Person:");
        System.out.println(somePerson.getName());
        System.out.println(somePerson.getPet().getName());
    }
}
