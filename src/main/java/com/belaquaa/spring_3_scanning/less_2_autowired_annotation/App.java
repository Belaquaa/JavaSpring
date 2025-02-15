package com.belaquaa.spring_3_scanning.less_2_autowired_annotation;

import com.belaquaa.spring_3_scanning.ScanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Создание Spring-Container-а:
        ApplicationContext springContainer = new AnnotationConfigApplicationContext(ScanConfig.class);

        // Получение значения зависимости, интегрированной с помощью конструктора:
        ConstructorIntegration constructorIntegration = springContainer.getBean("integrate-dependency-to-constructor", ConstructorIntegration.class);
        System.out.println(constructorIntegration.getDependencyValue());

        // Получение значения зависимости, интегрированной с помощью поля:
        FieldIntegration fieldIntegration = springContainer.getBean("integrate-dependency-to-field", FieldIntegration.class);
        System.out.println(fieldIntegration.getDependencyValue());

        // Получение значения зависимости, интегрированной с помощью set-тера:
        SetterIntegration setterIntegration = springContainer.getBean("integrate-dependency-to-setter", SetterIntegration.class);
        System.out.println(setterIntegration.getDependencyValue());
    }
}
