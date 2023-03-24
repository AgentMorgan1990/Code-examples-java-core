package ru.examples.core.oop.inheritance.example2;

public class BombeyCat extends Cat {
    private int c;
    public BombeyCat(int a, int b, int c) {
        super(a, b); // первым делом вызываем конструктор Cat
        this.c = c;
        System.out.println("Вызов конструктора BombeyCat");
    }
}
