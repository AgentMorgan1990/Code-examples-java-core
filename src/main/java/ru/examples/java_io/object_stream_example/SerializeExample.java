package ru.examples.java_io.object_stream_example;

import java.io.*;

public class SerializeExample {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("cat"));
        Cat cat1 = new Cat("Barsik", "White", 4);
        out.writeObject(cat1);

        ObjectInputStream is = new ObjectInputStream(new FileInputStream("cat"));
        Cat inputCat = (Cat) is.readObject();
        System.out.println(inputCat);
    }
}
