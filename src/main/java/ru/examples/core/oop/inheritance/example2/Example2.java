package ru.examples.core.oop.inheritance.example2;


/**
 * При вызове конструктора BombeyCat будут по цепочке вызваны конструкторы родительских классов,
 * начиная с самого первого класса Animal() => Cat() => BombeyCat()
 *
 * */
public class Example2 {
    public static void main(String[] args) {

        BombeyCat bombeyCat = new BombeyCat (1,2,3);
    }
}
