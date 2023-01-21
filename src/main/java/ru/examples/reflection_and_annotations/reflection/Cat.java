package ru.examples.reflection_and_annotations.reflection;

public class Cat {
    public String name;
    public String color;
    public int age;

    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Cat(String name) {
        this.name = name;
    }

    public Cat() {
    }


    public void jump() {
        System.out.println("Прыг- прыг");
    }

    public void meow(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("Гав что ли?");
        }
    }
}
