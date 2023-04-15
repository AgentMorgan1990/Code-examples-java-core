package ru.examples.java_io.buffered_reader_example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example2 {


    public static void main(String[] args) throws IOException {
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите символы, q для выхода");

        do {
            str = br.readLine();
            System.out.println(str);
        } while (!str.equals("q"));

    }
}
