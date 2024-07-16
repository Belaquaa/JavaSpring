package com.belaquaa.spring_3_scanning.less_4_primary_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {
    private final Engine engine;

    // Аннотация @Primary используется для указания приоритетного bean-а, который должен быть выбран автоматической
    // сборкой (autowiring), когда существует несколько кандидатов на внедрение зависимости одного и того же типа.
    //
    // В Spring приложениях часто возникают ситуации, когда для одного интерфейса определено несколько реализаций, и
    // все они являются bean-ами в контексте приложения. Если вы попытаетесь внедрить зависимость такого типа в другой
    // бин, без дополнительных указаний, Spring не сможет однозначно определить, какой из кандидатов использовать, и
    // выбросит исключение NoUniqueBeanDefinitionException.
    //
    // В нашем примере, если бы не было аннотации @Primary у класса V8Engine, Spring не смог бы определить, какой из
    // двух реализаций Engine внедрить в Vehicle. Однако благодаря @Primary, Spring выберет V8Engine как
    // предпочтительный бин для внедрения:
    @Autowired
    public Vehicle(Engine engine) {
        this.engine = engine;
    }

    // Использовать аннотацию @Primary можно как с аннотацией @Component, так и с @Bean (внутри класса конфигурации).

    // Spring не позволяет иметь более одного @Primary bean-а того же типа в контексте приложения. Если вы попытаетесь
    // это сделать, Spring выбросит исключение при старте приложения.

    public Engine getEngine() {
        return engine;
    }
}
