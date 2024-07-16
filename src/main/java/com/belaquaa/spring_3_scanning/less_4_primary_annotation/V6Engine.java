package com.belaquaa.spring_3_scanning.less_4_primary_annotation;

import org.springframework.stereotype.Component;

@Component
public class V6Engine implements Engine {
    @Override
    public void sound() {
        System.out.println("V6: Zoom-Zoom");
    }
}
