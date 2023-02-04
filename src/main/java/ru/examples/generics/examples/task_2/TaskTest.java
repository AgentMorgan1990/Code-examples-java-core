package ru.examples.generics.examples.task_2;

import java.util.ArrayList;

public class TaskTest {

    public static void main(String[] args) {
        ArrayMapper<Integer> arrayMapper = new ArrayMapper<>();

        Integer[] arr = new Integer[]{1,2,3,4};

        ArrayList<Integer> list = arrayMapper.mapToArrayList(arr);

        System.out.println(list);


    }
}
