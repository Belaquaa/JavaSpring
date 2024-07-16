package com.belaquaa.spring_3_scanning.less_7_value_annotation;

import com.belaquaa.spring_3_scanning.ScanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Создание Spring-Container-а:
        ApplicationContext springContainer = new AnnotationConfigApplicationContext(ScanConfig.class);

        // Извлечение из Spring-Container-а необходимого bean-а:
        IntegrateValues someValues = springContainer.getBean("integrateValues", IntegrateValues.class);
        System.out.println(someValues.numberValue);
        System.out.println(someValues.stringValue);
        System.out.println(someValues.booleanValue);
        System.out.println(someValues.numberFromFile);
        System.out.println(someValues.stringFromFile);
        System.out.println(someValues.booleanFromFile);
        System.out.println(someValues.defaultString);
    }
}
