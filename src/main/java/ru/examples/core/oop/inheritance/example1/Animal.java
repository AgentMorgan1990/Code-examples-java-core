package ru.examples.core.oop.inheritance.example1;

public class Animal {
    String name;
    public Animal() {
    }
    public Animal(String name) {
        this.name = name;
    }
    public void animalInfo() {
        System.out.println("Животное: " + name);
    }
    public void jump() {
        System.out.println("Животное подпрыгнуло");
    }
}
