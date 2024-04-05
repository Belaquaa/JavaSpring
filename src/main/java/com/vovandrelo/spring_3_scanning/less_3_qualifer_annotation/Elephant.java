package com.vovandrelo.spring_3_scanning.less_3_qualifer_annotation;

import org.springframework.stereotype.Component;

@Component("some-elephant")
public class Elephant implements Animal {
    public void aboutMe() {
        System.out.println("Фиолетовый слон Василий");
    }
}
