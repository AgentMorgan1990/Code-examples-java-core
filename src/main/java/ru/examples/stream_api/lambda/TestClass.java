package ru.examples.stream_api.lambda;

public class TestClass {

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        };

        //Сокращение выражения в лямбду по функциональному интерфейсу Runnable
        Runnable r2 = () -> System.out.println(2);

        //Пример лямбды для класса Thread, конструктор класса принимает Runnable
        new Thread(() -> {
            System.out.println(12);
            System.out.println(13);
        }).start();

        //Получение ссылки на реализацию метода
        Runnable current = r2;
        current.run();

        //Пример создания и реализации своего функционального интерфейса
        MyFunctionalInterface inter1 = (a, b) -> {
            System.out.println("Counting: " + (a + b));
        };

        MyFunctionalInterface inter2 = (a, b) -> {
            System.out.println("Multiplying " + (a * b));
        };

        MyFunctionalInterface current1 = inter1;
        current1.doSomething(5, 5);

        MyFunctionalInterface current2 = inter2;
        current2.doSomething(5, 5);

    }
}
