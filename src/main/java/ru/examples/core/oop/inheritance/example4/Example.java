package ru.examples.core.oop.inheritance.example4;

public class Example {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.voice();

        Animal animal = new Cat();
        animal.voice();
        if (animal instanceof Cat) {
            ((Cat)animal).methodFromCatClass();
            System.out.println("В animal действительно лежит кот");
        }
    }
}
