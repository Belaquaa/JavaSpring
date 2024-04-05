package com.vovandrelo.spring_2_configuration;

public class Person {
    private final String name;
    private final Pet pet;

    public Person(String name, Pet pet) {
        this.name = name;
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    public Pet getPet() {
        return pet;
    }
}
