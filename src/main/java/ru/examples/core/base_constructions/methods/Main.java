package ru.examples.core.base_constructions.methods;

public class Main {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.add("12");
        parent.add("12", "13");


        Child child = new Child();
        child.add("12", "12", "12");

        Child.print("12");
        Parent.print("12");
    }
}
