package com.belaquaa.spring_3_scanning.less_4_primary_annotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class V8Engine implements Engine {
    @Override
    public void sound() {
        System.out.println("V8: Wroom-Wroom");
    }
}
