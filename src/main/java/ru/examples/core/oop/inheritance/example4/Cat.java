package ru.examples.core.oop.inheritance.example4;

public class Cat extends Animal {
    @Override
    public void voice() {
        super.voice(); // вызываем метод voice() суперкласса
        System.out.println("Кот мяукнул");
    }

    public void methodFromCatClass(){
        System.out.println("Cat");
    }
}
