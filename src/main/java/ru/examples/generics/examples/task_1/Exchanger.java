package ru.examples.generics.examples.task_1;

public class Exchanger<T> {


    public void exchange(T[] array, T firstElement, T secondElement) {
        int firstElementIndex = 0;
        int secondElementIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(firstElement)) {
                firstElementIndex = i;
            } else if (array[i].equals(secondElement)) {
                secondElementIndex = i;
            }
        }
        array[firstElementIndex] = secondElement;
        array[secondElementIndex] = firstElement;
    }
}
