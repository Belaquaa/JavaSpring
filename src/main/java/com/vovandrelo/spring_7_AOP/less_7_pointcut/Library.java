package com.vovandrelo.spring_7_AOP.less_7_pointcut;

import org.springframework.stereotype.Component;

@Component
public class Library {
    public void getBook(String bookName) {
        System.out.println("Берём кингу: " + bookName);
        System.out.println("-----");
    }

    public void returnBook(String bookName) {
        System.out.println("Возвращаем кингу: " + bookName);
        System.out.println("-----");
    }
}
