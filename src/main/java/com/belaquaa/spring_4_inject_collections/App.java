package com.belaquaa.spring_4_inject_collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Создание Spring-Container-а:
        ApplicationContext springContainer = new AnnotationConfigApplicationContext(Config.class);

        // Получение всех bean-ов с типом String:
        IntegrateBeans example1 = springContainer.getBean("integrate-beans", IntegrateBeans.class);
        System.out.println(example1.getFruits());

        // Получение bean-а, представленного коллекцией List<String>:
        IntegrateCollection example2 = springContainer.getBean("integrate-collection", IntegrateCollection.class);
        System.out.println(example2.getFruits());
    }
}
