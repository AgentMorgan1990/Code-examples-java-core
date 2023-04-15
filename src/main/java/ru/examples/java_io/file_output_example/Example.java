package ru.examples.java_io.file_output_example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example {

    public static void main(String[] args) {
        int i;
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream("1.txt");
            fos = new FileOutputStream("2.txt");

            do {
                i = fis.read();
                if (i != -1) {
                    System.out.println((char) i);
                    fos.write(i);
                }
            } while (i != -1);

        } catch (IOException e) {
            System.out.println("Ошибка при копировании файла");
        } finally {
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {
                System.out.println("Ошибка при закрытиии входящего потока");
            }
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии исходящего потока");
            }
        }
    }
}
