package ru.examples.collection;

import java.util.ArrayList;
import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(arr));
        int[] tmpArr = new int[10];
        System.arraycopy(arr,0,tmpArr,0,arr.length);
        System.out.println(Arrays.toString(tmpArr));
    }
}
