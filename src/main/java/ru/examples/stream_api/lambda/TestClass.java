package ru.examples.stream_api.lambda;

public class TestClass {

    public static void main(String[] args) {

        /**
         * В данном методе фактически происходит создание объекта анонимного кдасса с переопределением метода Run
         * Анонимный класс создаётся с именем - public class TestClass$1 implements Runnable
         * Применяется имя класса в котором этот анонимный класс создан с $1
         * */

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        };


        /**
         * Пример выаода имени анонимного класса - ru.examples.stream_api.lambda.TestClass$2
         * */
        System.out.println(new TestClass(){}.getClass().getName());

        /**
         * Сокращение выражения в лямбду по функциональному интерфейсу Runnable
         * Сохраняем в переменной ссылку на метод через объект анононимного класса
         * */
        Runnable r2 = () -> System.out.println(2);

        //Пример лямбды для класса Thread, конструктор класса принимает Runnable
        new Thread(() -> {
            System.out.println(12);
            System.out.println(13);
        }).start();

        /**
         *
         * В данном примере мы фактически можем получать в один объект ссылки на разные методы
         * Получение ссылки на реализацию метода
         * */

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
