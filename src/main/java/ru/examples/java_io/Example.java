package ru.examples.java_io;

import java.io.*;

public class Example {


    public static void main(String[] args) {

        try {
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String str = inputStream.readLine();
                if (str.equals("Q")) {
                    break;
                }
                System.out.println(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
