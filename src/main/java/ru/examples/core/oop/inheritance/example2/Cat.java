package ru.examples.core.oop.inheritance.example2;

public class Cat extends Animal {
    private int b;
    protected int z;
    public Cat(int a, int b) {
        super(a); // первым делом вызываем конструктор Animal
        this.b = b;
        System.out.println("Вызов конструктора Cat");
    }
    public void test() {
        z = 10; // Обращение к полю z класса Cat
        super.z = 20; // Обращение к полю z класса Animal
    }
}
