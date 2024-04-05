package com.vovandrelo.spring_3_scanning.less_6_lookup_annotation;


import com.vovandrelo.spring_3_scanning.ScanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Создание Spring-Container-а:
        ApplicationContext springContainer = new AnnotationConfigApplicationContext(ScanConfig.class);

        // Извлечение bean-а SingletonBean, который может возвращать prototype-bean-ы:
        SingletonBean singletonBean = springContainer.getBean("singletonBean", SingletonBean.class);

        // Получение prototype bean-ов:
        PrototypeBean somePrototypeBean1 = singletonBean.getPrototypeBean();
        PrototypeBean somePrototypeBean2 = singletonBean.getPrototypeBean();

        // Полученные bean-ы действительно prototype:
        System.out.println(somePrototypeBean1 == somePrototypeBean2);   // false
    }
}
