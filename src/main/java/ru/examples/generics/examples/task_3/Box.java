package ru.examples.generics.examples.task_3;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private List<T> fruits = new ArrayList<>();

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public double getWeight() {
        double sum = 0.0;

        for (Fruit fruit : fruits) {
            sum += fruit.getWeight();

        }
        return sum;
    }

    public void pour(Box<T> anotherBox) {
        for (T fruit : fruits) {
            anotherBox.add(fruit);
        }
        fruits.clear();
    }


}
