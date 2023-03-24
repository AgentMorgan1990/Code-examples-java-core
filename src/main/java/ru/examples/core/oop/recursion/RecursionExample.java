package ru.examples.core.oop.recursion;

public class RecursionExample {


    public static void main(String[] args) {
        printArray(10);
    }

    public static void printArray(int i) {
        if (i == 0) {
            return;
        } else {
            printArray(i - 1);
            System.out.println(i - 1);
        }

    }
}
