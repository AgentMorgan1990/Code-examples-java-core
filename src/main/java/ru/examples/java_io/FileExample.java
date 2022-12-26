package ru.examples.java_io;

import java.io.*;
import java.util.Arrays;


/**
 * В классе File есть множество методов для работы с файлами и папками
 *
 * Байтовые потоки - читаем пишем побайтово
 * InputStream, OutputStream
 *
 * FileInputStream, FileOutputStream - чтение, запись в файл
 *
 * BufferedInputStream, BufferedOutputStream - буфферизированный поток
 *
 * DataOutputStream и DataInputStream - даёт возможность работать с примитивами, например long,
 * без углубления в побитовые сдвиги. Например, читать в формате UTF-8
 *
 * InputStreamReader - даёт возможность чтения, когда в кодировке больше одного байта
 *
 * Символьные потоки - читаем пишем посимвольно
 * Reader, Writer - аналог InputStream, OutputStream для символов
 *
 * FileReader, FileWriter - аналог ileInputStream, FileOutputStream для символов
 *
 * BufferedReader, BufferedWriter аналог BufferedInputStream, BufferedOutputStream для символов
 *
 */

public class FileExample {
    public static void main(String[] args) throws IOException {
        File file = new File("1.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        /**
         * InputStreamReader - для чтения, когда в кодировке больше одного байта
         *
         * */
        InputStreamReader in1 = new InputStreamReader(new FileInputStream("1.txt"));
        int z;
        while ((z = in1.read()) != -1) {
            System.out.print((char) z);
        }

        /**
         *
         * Запись через BufferedOutputStream
         * используется буфферизированный поток, для ускорения записи
         *
         * .flush() - используем, чтобы принудительно вытолкнуть данные из потока
         *
         * */
        OutputStream out1 = new BufferedOutputStream(new FileOutputStream("5mb2.txt"));
        for (int i = 0; i < 1024 *  1024 * 5; i++) {
            out1.write(65);
            out1.flush();
        }

        /**
         *
         * Чтение через BufferedOutputStream
         * используется буфферизированный поток, для ускорения чтения
         *
         * */
        InputStream os2 = new BufferedInputStream(new FileInputStream("5mb2.txt"));
        int x;
        while ((x = os2.read()) != -1) {
            System.out.print((char) x);
        }

        /**
         * Запись в файл массивами
         *
         * используем для ускорения записи, через стандартный FileOutputStream
         *
         * */
        byte[] arr = new byte[1024];
        Arrays.fill(arr, (byte) 65);

        OutputStream out = new FileOutputStream("5mb.txt");
        for (int i = 0; i < 1024 * 5 ; i++) {
            out.write(arr);
        }

        /**
         * Чтение из файла массивами
         *
         * используем для ускорения записи, через стандартный FileInputStream
         *
         * используем переменную len, чтобы не распечатать "хвост" с предыдущего чтения
         *
         * */
        byte[] data = new byte[64];
        FileInputStream is1 = new FileInputStream("5mb2.txt");
        int len = 0;
        while ((len = is1.read(data))>0){
            System.out.println(new String(data,0,len));
        }

        /**
         * Побайтное чтение из файла, может быть очень медленным, в таком виде лучше не использовать
         *
         * */
        FileInputStream in = new FileInputStream("1.txt");
        int y;
        while ((y = in.read()) != -1) {
            System.out.print((char) y);
        }

        /**
         * Побайтная запись в файл, может быть очень медленным, в таком виде лучше не использовать
         *
         * */
        FileOutputStream os = new FileOutputStream("2.txt");
        os.write(65);
        os.write(34);
        os.write("Hello, World!!!".getBytes());

    }
}
