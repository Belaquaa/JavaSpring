package com.vovandrelo.spring_3_scanning.less_1_component_annotation;

import com.vovandrelo.spring_3_scanning.ScanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Создание Spring-Container-а:
        ApplicationContext springContainer = new AnnotationConfigApplicationContext(ScanConfig.class);

        // Извлечение bean-а MyComponent, который был создан автоматически на основании аннотации @Component:
        MyComponent myComponent = springContainer.getBean("someName", MyComponent.class);
        myComponent.saySomething();
    }
}
