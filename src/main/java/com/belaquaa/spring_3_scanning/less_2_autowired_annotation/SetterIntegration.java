package com.belaquaa.spring_3_scanning.less_2_autowired_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("integrate-dependency-to-setter")
public class SetterIntegration {
    private Dependency dependency;

    // Аннотация @Autowired используется для автоматической внедрения зависимостей через механизм инъекции. Это
    // означает, что Spring автоматически устанавливает значения в поля, конструкторы или методы bean-ов, если они
    // помечены этой аннотацией.
    //
    // Spring использует типы данных для поиска соответствующих bean-ов, которые должны быть внедрены. Если в контексте
    // приложения найдено несколько bean-ов одного и того же типа, необходимо использовать дополнительные механизмы для
    // указания, какой именно бин следует использовать (например, аннотацию `@Qualifier`).
    //
    // В данном случае происходит внедрение с помощью set-тера:
    @Autowired
    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }

    public String getDependencyValue() {
        return dependency.getSomeValue();
    }

    // Полностью аналогичная аннотация из стандарта JSR-330: @Inject
    // Основное отличие:
    // - @Inject: Если зависимость не будет найдена, то исключения не будет, а значением будет null;
    // - @Autowired: Если зависимость не будет найдена, то вылетит исключения, однако, с помощью параметра required
    //   со значением false может иметь поведение, аналогичное @Inject;
}
