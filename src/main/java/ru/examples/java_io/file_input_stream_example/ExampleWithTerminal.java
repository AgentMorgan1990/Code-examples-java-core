package ru.examples.java_io.file_input_stream_example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExampleWithTerminal {

    // java ShowFile ТЕSТ.ТХТ - в коммандной строке

    public static void main(String[] args) {
        int i;
        FileInputStream fis;

        if (args.length != 1) {
            System.out.println("Использование : ShowFile имя_файла");
            return;
        }

        try {
            fis = new FileInputStream(args[0]);
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
        }
        try {
            fis.close();
        } catch (IOException e) {
            System.out.println("Ошибка закрытия файла");
        }
    }
}
