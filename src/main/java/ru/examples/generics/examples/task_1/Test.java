package ru.examples.generics.examples.task_1;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        Exchanger exchanger = new Exchanger();

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        exchanger.exchange(arr, 3, 8);

        System.out.println(Arrays.toString(arr));


        Exchanger exchanger1 = new Exchanger();

        String[] arr1 = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven"};

        exchanger1.exchange(arr1, "Two", "Six");

        System.out.println(Arrays.toString(arr1));
    }

}
