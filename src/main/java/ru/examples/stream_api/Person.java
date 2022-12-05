package ru.examples.stream_api;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    enum Position {
        ENGINEER, DIRECTOR, MANAGER;
    }

    private String name;
    private int age;
    private Position position;

    public Person(String name, int age, Position position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }
}
