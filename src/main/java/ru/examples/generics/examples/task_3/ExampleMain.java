package ru.examples.generics.examples.task_3;

public class ExampleMain<T> {

    public static void main(String[] args) {

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();

        Box<Apple> box1 = new Box<>();
        Box<Apple> box2 = new Box<>();
        Box<Orange> box3 = new Box<>();

        box1.add(apple1);
        box1.add(apple2);
        box2.add(apple3);
        box3.add(orange1);
        box3.add(orange2);
        box3.add(orange3);

        System.out.println(box1.getWeight());
        System.out.println(box2.getWeight());
        System.out.println(box3.getWeight());

        box1.pour(box2);

        System.out.println(box1.getWeight());
        System.out.println(box2.getWeight());
        System.out.println(box3.getWeight());
    }

}
