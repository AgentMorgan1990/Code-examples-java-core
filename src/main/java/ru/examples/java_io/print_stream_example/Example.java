package ru.examples.java_io.print_stream_example;

public class Example {

    //У System.out можно вызвать низкоуровневый метод write, вместо print()

    public static void main(String[] args) {
        int b;
        b = 'A';
        System.out.write(b);
        System.out.write('\n');
    }
}


