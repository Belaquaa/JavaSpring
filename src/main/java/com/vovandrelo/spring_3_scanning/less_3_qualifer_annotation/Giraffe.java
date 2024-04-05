package com.vovandrelo.spring_3_scanning.less_3_qualifer_annotation;

import org.springframework.stereotype.Component;

@Component("some-giraffe")
public class Giraffe implements Animal {
    public void aboutMe() {
        System.out.println("Оранжевый жираф Гриша");
    }
}
