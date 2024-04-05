package com.vovandrelo.spring_3_scanning.less_4_primary_annotation;

import com.vovandrelo.spring_3_scanning.ScanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Создание Spring-Container-а:
        ApplicationContext springContainer = new AnnotationConfigApplicationContext(ScanConfig.class);

        // Извлечение из Spring-Container-а необходимого bean-а:
        Vehicle someVehicle = springContainer.getBean("vehicle", Vehicle.class);
        someVehicle.getEngine().sound();
    }
}
