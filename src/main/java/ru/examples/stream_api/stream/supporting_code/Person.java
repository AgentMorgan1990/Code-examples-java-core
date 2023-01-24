package ru.examples.stream_api.stream.supporting_code;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    public enum Position {
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
