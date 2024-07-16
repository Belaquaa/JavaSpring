package com.belaquaa.spring_4_inject_collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("com.belaquaa.spring_4_inject_collections")
class Config {

    // В качестве зависимостей классов могут так же использоваться коллекции и массивы. Рассмотрим пример с коллекций
    // List<String>, но данное поведение будет аналогичным для всех коллекций и массивов любого типа.
    //
    // При использовании @Autowired совместно с List<String>, Spring реализует следующие поведение:
    //  1. Поиск всех bean-ов с типом String и объединение их в List<String>;
    //  2. Если bean-ов с типом String не существует, происходит поиск коллекции List<String>;
    //
    // Это означает, что если в Spring-Container-е находятся как bean-ы с типом String, так и коллекция List<String>,
    // то предпочтение по внедрению отдастся всем bean-ам с типом String, а коллекция интегрирована не будет.

    @Bean("fruits")
    public List<String> fruits() {
        List<String> someList = new ArrayList<>();
        someList.add("apple");
        someList.add("banana");
        someList.add("orange");
        return someList;
    }

    @Bean("some-fruit")
    public String someFruit() {
        return "some fruit";
    }
}
