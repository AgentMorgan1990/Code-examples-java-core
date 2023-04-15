package ru.examples.java_io.file_input_stream_example;

import java.io.FileInputStream;
import java.io.IOException;

public class ImprovedExample {
    public static void main(String[] args) {

        int i;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("1.txt");
            do {
                i = fis.read();
                if (i != -1) System.out.println((char) i);
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии файла");
            }
        }
    }
}
