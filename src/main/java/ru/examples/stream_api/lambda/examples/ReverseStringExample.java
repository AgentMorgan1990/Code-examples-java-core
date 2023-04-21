package ru.examples.stream_api.lambda.examples;

public class ReverseStringExample {
}

interface StringFunc {
    String func(String n);
}

class BlockLambda2 {

    public static void main(String[] args) {
        StringFunc reverse = str -> {
            //для эффективности нужно добавить стрингбилдер
            String s = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                s += str.charAt(i);
            }
            return s;
        };
        System.out.println("Наоборот " + reverse.func("Наоборот"));
    }
}
