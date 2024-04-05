package com.vovandrelo.spring_7_AOP.less_7_pointcut;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Library library = context.getBean("library", Library.class);
        library.getBook("Мастер и Маргарита");
        library.returnBook("Мастер и Маргарита");

        context.close();
    }
}
