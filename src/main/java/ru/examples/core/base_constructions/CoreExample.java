package ru.examples.core.base_constructions;

import java.util.Arrays;
import java.util.Scanner;

public class CoreExample {
    public static void main(String[] args) {
//        useTernaryOperator();
//        useSwitch();
//        useSimpleFor();
//        useForWithTwoCounter();
//        useForWithBreak();
//        useForEach();
//        useForWithNestedLoop();
//        useWhile();
//        useDoWhile();
//        createArray();
//        createTwoDimensionalArray();
//        consoleInput();
//        selectNumber(20,45);
//        usingPrintf();
        usingForEachInTwoDimensionalArray();
    }

    private static void useTernaryOperator() {
        /**
         * Использование тернарного оператора ?
         * */
        int a = 12;
        System.out.println(a > 10 ? "+" : "-");

        if (a > 10) {
            System.out.println("+");
        } else {
            System.out.println("-");
        }
    }

    private static void useSwitch() {
        /**
         * Пример использования switch
         * */
        int b = 3;
        switch (b) {
            case 1:
                System.out.println("a = 1");
                break;
            case 3:
                System.out.println("a = 3");
                break;
            default:
                System.out.println("Ни один из case не сработал");
        }
    }

    private static void useSimpleFor() {
        for (int i = 0; i < 5; i++) {
            System.out.println("i = " + i);
        }
        System.out.println("end");
    }

    private static void useForWithTwoCounter() {
        for (int i = 0, j = 10; i < j; i++, j--) {
            System.out.println("i-j: " + i + "-" + j);
        }
    }

    private static void useForWithBreak() {
        for (int i = 0; i < 10; i++) {
            if (i > 3) {
                break;
            }
            System.out.println("i = " + i);
        }
    }

    private static void useForEach() {
        String[] sm = {"A", "B", "C", "D"};
        for (String o : sm) {
            System.out.print(o + " ");
        }
    }

    private static void useForWithNestedLoop() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + i + j);
            }
        }
    }

    private static void useWhile() {
        int r = 0;
        while (true) {
            System.out.println(r);
            r++;
            if (r > 20) {
                break;
            }
        }
    }

    private static void useDoWhile() {
        int e = 1;
        do {
            System.out.println(e);
            e++;
        } while (e < 10);
    }

    private static void createArray() {
        int[] arr = new int[5];
        int[] indexes = {1, 5, 6, 9, 23, 67, 67};
        arr[0] = 6;
        arr[1] = 8;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(indexes));
    }

    private static void createTwoDimensionalArray() {
        int[][] arr = {{1, 2, 3}, {3, 4, 5}, {1, 8, 9, 80}};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void consoleInput() {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println("Введено " + i);
        scanner.close();
    }

    private static int selectNumber(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        do {
            System.out.println("Введите число от " + min + " до " + max);
            x = scanner.nextInt();
        } while (x < min || x > max);
        System.out.println("Вы ввели число " + x);
        return x;
    }

    private static void usingPrintf(){
        System.out.printf("Слово: %s, Число с плавающей запятой: %f, Целое число: %d, Символ: %c", "Java", 2.5f, 20, 'e');
    }

    private static void usingForEachInTwoDimensionalArray(){
        int sum = 0;
        int[][] nums = new int[3][5];

        // give nums some values
        for(int i = 0; i < 3; i++)
            for(int j=0; j < 5; j++)
                nums[i][j] = (i+1)*(j+1);

        // use for-each for to display and sum the values
        for(int[] x : nums) {
            for(int y : x) {
                System.out.println("Value is: " + y);
                sum += y;
            }
        }
        System.out.println("Summation: " + sum);
    }

}

