package ru.examples;

import java.util.Arrays;

public class Example {

    public static int[] returnArr(int[] arr) {

        Integer index = null;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                index = i;
            }
        }

        if (index == null) {
            throw new RuntimeException();
        }
        return Arrays.copyOfRange(arr, index + 1, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 5, 4, 7, 8, 9, 15, 4, 5, 6, 7};
        System.out.println(Arrays.toString(returnArr(arr)));
    }
}
