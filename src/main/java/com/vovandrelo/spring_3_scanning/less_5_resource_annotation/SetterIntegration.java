package com.vovandrelo.spring_3_scanning.less_5_resource_annotation;


import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("integrate-named-dependency-to-setter")
public class SetterIntegration {
    public NamedDependency dependency;

    // Аннотация @Resource используется для автоматического внедрения зависимостей через механизм инъекции. Это
    // означает, что Spring автоматически устанавливает значения в поля или методы bean-ов, если они помечены этой
    // аннотацией.
    //
    // В отличие от @Autowired, по-умолчанию выполняет внедрение по имени bean-а. Если bean с указанным именем не будет
    // найден, то произойдёт внедрение по типу (аналогично  @Autowired). Для указания имени bean-а существует 2 способа:
    //  - Аннотация @Resource имеет атрибут name;
    //  - Если name не указан, то в качестве имени будет выступать имя аннотируемого сеттера или поля;
    //
    // В данном случае происходит внедрение с помощью set-тера:
    @Resource(name = "unique-bean-name")
    public void setDependency(NamedDependency dependency) {
        this.dependency = dependency;
    }

    public String getDependencyValue() {
        return dependency.getSomeValue();
    }

    // Аннотация @Resource не является частью самого Spring, а предоставляется Java EE: это стандартная аннотация Java,
    // определённая в JSR-250.
}
