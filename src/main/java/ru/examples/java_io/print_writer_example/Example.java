package ru.examples.java_io.print_writer_example;

import java.io.PrintWriter;

//PrintWriter упрощает интернационализацию реальных программ.

public class Example {
    public static void main(String[] args) {
        PrintWriter pr = new PrintWriter(System.out, true);
        pr.println("Это строка");
        int i = -7;
        pr.println(i);
        double d = 4.5e-7;
        pr.println(d);
    }
}
