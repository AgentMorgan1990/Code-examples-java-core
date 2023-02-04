package ru.examples.generics.examples.task_2;

import java.util.ArrayList;
import java.util.List;

public class ArrayMapper<T> {

    public ArrayList<T> mapToArrayList(T[] array) {

        return new ArrayList<>(List.of(array));
    }
}

