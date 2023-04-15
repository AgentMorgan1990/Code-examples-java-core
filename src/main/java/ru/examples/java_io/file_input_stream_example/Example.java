package ru.examples.java_io.file_input_stream_example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Example {
    public static void main(String[] args) {

        int i;
        FileInputStream fis;

        try {
            fis = new FileInputStream("1.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Невозможно открыть файл");
            return;
        }

        try {
            do {
                i = fis.read();
                if (i != -1) System.out.println((char) i);

            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Ошибка чтения из файла");
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                System.out.println("Ошибка закрытия файла");
            }
        }
    }
}
