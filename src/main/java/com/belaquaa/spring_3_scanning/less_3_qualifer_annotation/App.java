package com.belaquaa.spring_3_scanning.less_3_qualifer_annotation;

import com.belaquaa.spring_3_scanning.ScanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Создание Spring-Container-а:
        ApplicationContext springContainer = new AnnotationConfigApplicationContext(ScanConfig.class);

        // Извлечение из Spring-Container-а необходимого bean-а:
        Aviary someAviary = springContainer.getBean("some-aviary", Aviary.class);
        someAviary.checkInside();
    }
}
