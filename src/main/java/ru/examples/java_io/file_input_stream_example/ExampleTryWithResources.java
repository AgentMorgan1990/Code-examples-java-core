package ru.examples.java_io.file_input_stream_example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExampleTryWithResources {


    public static void main(String[] args) {
        int i;
        try (FileInputStream fis = new FileInputStream("1.txt")) {

            do {
                i = fis.read();
                if (i != -1) System.out.println((char) i);
            } while (i != -1);
        } catch (FileNotFoundException e) {
            System.out.println("Файд не найден");

        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }
    }
}
