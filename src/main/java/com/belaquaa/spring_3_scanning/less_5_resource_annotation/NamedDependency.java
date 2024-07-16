package com.belaquaa.spring_3_scanning.less_5_resource_annotation;

import org.springframework.stereotype.Component;

@Component("unique-bean-name")
public class NamedDependency {
    public String getSomeValue() {
        return "Some dependency";
    }
}
