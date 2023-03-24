package ru.examples.core.base_constructions;

public class BitwiseOperatorsExample {

    public static void main(String[] args) {
        byte binaryNumber = 0b0000_0000;

        byte binaryNumber1 = ~0b0000_0000; //так обозначается отрицательное число с помощью оператора ~

        System.out.println(binaryNumber);
        System.out.println(binaryNumber1);
    }
}
