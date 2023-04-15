package ru.examples.java_io.file_output_example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExampleTryWithResources {

    public static void main(String[] args) {
        int i;

        try (FileInputStream fis = new FileInputStream("1.txt");
             FileOutputStream fos = new FileOutputStream("3.txt")) {

            do {
                i = fis.read();
                if (i != -1) {
                    System.out.println((char) i);
                    fos.write(i);
                }
            } while (i != -1);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Problem with io");
        }
    }
}
