package com.belaquaa.spring_4_inject_collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("integrate-collection")
public class IntegrateCollection {
    private final List<String> fruits;

    // Для того чтобы произвести интеграцию конкретной коллекции List<String>, а не всех bean-ов с типом String,
    // необходимо дополнительно задействовать аннотацию @Qualifier:
    @Autowired
    IntegrateCollection(@Qualifier("fruits") List<String> fruits) {
        this.fruits = fruits;
    }

    public List<String> getFruits() {
        return fruits;
    }
}