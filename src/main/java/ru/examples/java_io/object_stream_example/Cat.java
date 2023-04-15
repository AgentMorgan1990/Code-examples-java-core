package ru.examples.java_io.object_stream_example;

import java.io.Serializable;

public class Cat implements Serializable {

    private String name;
    private String color;
    private int age;


    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }
}
