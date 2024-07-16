package com.belaquaa.spring_5_bean_life_cycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Создание Spring-Container-а:
        AnnotationConfigApplicationContext springContainer = new AnnotationConfigApplicationContext(Config.class);

        // Извлечение из Spring-Container-а необходимого bean-а:
        Animal someAnimal = springContainer.getBean("animal", Animal.class);
        someAnimal.sayHello();

        springContainer.close();
    }
}
