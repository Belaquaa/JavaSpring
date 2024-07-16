package com.belaquaa.spring_3_scanning.less_2_autowired_annotation;

import org.springframework.stereotype.Component;

@Component
public class Dependency {
    public String getSomeValue() {
        return "Some dependency";
    }
}
