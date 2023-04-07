package ru.examples.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.stream.Stream;

public class MainApp {
    public static void main(String[] args) throws IOException {

        /**
         * Предпочтительнее использовать первы вариант, т.к. в неё можно использовать разные операционные/файловые системы
         * */
        Path path = Paths.get("example", "1.txt");
        Path path1 = Paths.get("example/1.txt");
        System.out.println(Files.exists(path));
        System.out.println(path);
        System.out.println(path.getFileName());
        System.out.println(path.getName(path.getNameCount() - 2));
        System.out.println(path.getFileSystem());
        System.out.println(path.isAbsolute());
        /**
         * Тут можно повесить watchService, который будет следить за изменениями в папке, но на Windows может работать криво
         * */
//        System.out.println(path.register());
        System.out.println(path.toAbsolutePath());

        /**
         * Переход из nio в io, в io есть аналогичный метод для обратного перехода
         * */
        System.out.println(path.toFile());

        /**
         * Path - является иммутабельным, работаем как со строкой)
         *
         * */
        Path path2 = Paths.get("example");
        path2 = path2.resolve("2.txt");
        System.out.println(path2);


        System.out.println(Files.isDirectory(path));

        byte[] bytes = "Java".getBytes();
        Files.write(Paths.get("example", "2.txt"),bytes, StandardOpenOption.CREATE);

        /**
         * Прочитать все байты из файла, можно использовать в простых кейсах.
         * */
        byte[] in = Files.readAllBytes(Paths.get("example", "1.txt"));


        /**
         * Метод с реализацией обхода дерева папок, нужно выбрать реализацию FileVisitor, которая показывает , что
         * делать во время обход. В реализации SimpleFileVisitor можно переопределитьм методы, перед входом в файл, во
         * время открытия файла, при ошибке открытия, после открытия
         * */
        Files.walkFileTree(Paths.get("example"), new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.getFileName());
                return FileVisitResult.CONTINUE;
            }
        });

        /**
         * Возвращает все строчки в файле
         * */
        List<String> stringList = Files.readAllLines(path);
        System.out.println(stringList);

        /**
         * Возвращает все строчки в виде стрима
         * */
        Stream<String> stringStream = Files.lines(path);

        /**
         * Копирование файлов с разными опциями записи
         * */
        Files.copy(Paths.get("example/1.txt"), Paths.get("example/3.txt"), StandardCopyOption.REPLACE_EXISTING);


        /**
         * Пример передачи данных из файла в файл, можно пользоваться любым из двух методов .transferTo() .transferFrom()
         *
         * Channel - двунаправленный и асинхронный
         *
         * Есть несколько видов каналов:
         *
         * FileChannel          - передача файлов
         * DatagramChannel      - сетевой канал по протоколу UDP
         * SocketChannel        - сетевой канал по протоклу TCP, аналог сокета, который реализовывали на клиенте в чате
         * ServerSocketChannel  - канал для подключения клиентов, аналог сервер сокета на сервере
         *
         *
         * */
        RandomAccessFile src = new RandomAccessFile("1.txt","rw");
        FileChannel srcCh = src.getChannel();

        RandomAccessFile dst = new RandomAccessFile("2.txt","rw");
        FileChannel dstCh = dst.getChannel();

        srcCh.transferTo(0,srcCh.size(),dstCh);
        dstCh.transferFrom(srcCh,0,srcCh.size());

        /**
         * Можно переливать из файлового наканала в сокет канал для передачи на сервак, нужно только выбрать
         * правильную реализацию SocketChannel
         * */
//        SocketChannel socketChannel = new SocketChannel();
//        srcCh.transferTo(0,srcCh.size(),socketChannel);

        /**
         * Пример создния канала и байтбффера длнео дятения
         * "rw" - "read-write" mode
         * */
        RandomAccessFile file = new RandomAccessFile("1.txt", "rw");
        FileChannel channel = file.getChannel();
        //Создаём байтбуффер с размером 8 байт
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);

        int bytesRead = channel.read(byteBuffer);
        while (bytesRead > -1) {
            //переводим буфер в режим чтения
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.println((char) byteBuffer.get());
            }
            byteBuffer.clear();
            bytesRead = channel.read(byteBuffer);
        }


        /**
         * Пример обхода папки и сортировки папок и файлов с добавлением в файлы нового обозначения
         * */
//        List<String> filesList =
                Files.list(Paths.get("."))
//                .filter(p->!Files.isDirectory(p))
//                .map(p->p.getFileName().toString())
                .sorted((o1, o2) -> {
                    if (Files.isDirectory(o1) && !Files.isDirectory(o2)) {
                        return -1;
                    } else if (!Files.isDirectory(o1) && Files.isDirectory(o2)) {
                        return 1;
                    } else return 0;
                })
                .map(p -> {
                    if (!Files.isDirectory(p)) {
                        return p.getFileName().toString();
                    } else {
                        return "[" + p.getFileName().toString() + "]";
                    }
                })
//                .collect(Collectors.toList());
                .forEach(System.out::println);


    }
}
