package ru.examples.java_io.buffered_reader_example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = new String[100];
        System.out.println("Введите строки текста");
        System.out.println("Введите стоп для завершения");
        for (int i = 0; i < 100; i++) {
            strings[i] = br.readLine();
            if (strings[i].equals("стоп")) {
                break;
            }
        }
        System.out.println("Вывести содержимое файла");
        for (int i = 0; i < 100; i++) {
            if (strings[i].equals("стоп")) {
                break;
            }
            System.out.println(strings[i]);
        }
    }
}
