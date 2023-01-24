package ru.examples.exceptions;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExceptionExampleApp {
    public static void main(String[] args) {
        usingTryCatch();
        usingDoubleCatch();
        usingTryWithResources();


    }

    private static void usingTryWithResources() {

        //В такой конструкции Java закроет utputStream
        try (FileOutputStream os = new FileOutputStream("File.txt")) {
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void usingTryCatch() {
        int a, b;
        try {
            a = 0;
            b = 10 / a;
            System.out.println("Это сообщение не будет выведено в консоль");
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }
        System.out.println("Завершение работы");
    }

    public static void usingDoubleCatch() {
        try {
            int a = 10;
            a -= 10;
            int b = 42 / a;
            int[] с = {1, 2, 3};
            с[42] = 99;
        } catch (ArithmeticException e) {
            System.out.println("Дeлeниe на ноль: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка индексации массива: " + e);
        }
        System.out.println("Пocлe блока операторов try/catch");
    }
}
