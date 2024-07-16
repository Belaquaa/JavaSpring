package com.belaquaa.spring_3_scanning.less_3_qualifer_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("some-aviary")
public class Aviary {
    private final Animal animal1;
    private final Animal animal2;

    // Аннотация @Qualifier в Spring Framework используется для уточнения выбора bean-а, когда имеется несколько
    // кандидатов на внедрение зависимости. Это может быть полезно, когда в контексте приложения определено несколько
    // bean-ов одного и того же типа, но для конкретного использования необходим определенный бин.
    //
    // Аннотация @Qualifier используется совместно с @Autowired и может быть расположена:
    // - В конструкторе;
    // - В сеттерах и других методах, принимающих параметры;
    // - На полях, хотя внедрение зависимостей через поля (field injection) обычно считается менее предпочтительным по
    //   сравнению с конструктором или сеттерами.
    @Autowired
    public Aviary(@Qualifier("some-giraffe") Animal animal1, @Qualifier("some-elephant") Animal animal2) {
        this.animal1 = animal1;
        this.animal2 = animal2;
    }

    // В приведенном примере мы определили два bean-а, которые реализуют интерфейс Animal: Elephant и Giraffe. При
    // внедрении зависимостей в Aviary мы используем @Qualifier, чтобы указать, в какое поле какой необходимо внедрить
    // bean.

    public void checkInside() {
        System.out.println("В вольере сидит:");
        animal1.aboutMe();
        animal2.aboutMe();
    }
}
