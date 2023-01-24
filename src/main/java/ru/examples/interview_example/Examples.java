package ru.examples.interview_example;


public class Examples {


    static class Example1 {
        public static void main(String[] args) {
            int i = 0;
            System.out.println(i++);
            System.out.println(i + 1);
            System.out.println(i);
        }
    }

    static class Example2{
        /**
         * Выводится имя класса с пакетом + хэшкод в 16-ричном представлении, т.к. по факту пользуемся методом toString
         * класса Object
         * */
        public static void main(String[] args) {
            System.out.println(new Example2());
        }
    }

    static class Example3 {

        /**
         * Сначала отрабатывает блок статической инициализации, потом отрабатывает блок динамической инициализации,
         * а только потом конструктор
         * */
        {
            System.out.println("Test 3 dynamic");
        }

        static {
            System.out.println("Test 3 static");
        }

        public Example3() {
            System.out.println("Test 3");
        }

        public static void main(String[] args) throws ClassNotFoundException {
            Class class1 = Class.forName("ru.examples.interview_example.Examples$Example3");

            Example3 example3 = new Example3();
            Example3 example4 = new Example3();
        }
    }

    static class Example4 extends Example3{
        /**
         * Сначала по всем классам отрабатывают блоки статической инициализации, потом отрабатывает блок динамической
         * инициализации у родителя и конструктор родителя, а только потом блок динамической инициализации у наследника
         * и конструктор наследника
         * */
        {
            System.out.println("Test 4 dynamic");
        }

        static {
            System.out.println("Test 4 static");
        }

        public Example4() {
            System.out.println("Test 4");
        }

        public static void main(String[] args) {
            new Example3();
            new Example4();
            new Example4();
        }
    }

    static class Example5 {
        public static void main(String[] args) {

            /**
             * .intern() - возвращает ссылку из пула строк
             * */

            String example = "Example";

            String baseString = new String("Example 5");
            String str1 = new String("Example 5");
            String str2 = "Example 5";
            String str3 = example + " 5";
            String str4 = example.concat(" 5");
            String str5 = baseString.intern();

            System.out.println(baseString == str1);
            System.out.println(baseString == str2);
            System.out.println(baseString == str3);
            System.out.println(baseString == str4);
            System.out.println(baseString == str5);
        }
    }



    static class Example6 {

        /**
         * Short, Integer, Long хранят байтовый кэш, который сначала проверяем своё содержимое, если значение больше 127,
         * проверяем уже ссылки на объекты
         */

        public static void main(String[] args) {
            Integer i1 = 128;
            Integer i2 = 128;
            System.out.println(i1 == i2);

            Integer i3 = 127;
            Integer i4 = 127;
            System.out.println(i3 == i4);
        }
    }


    static class Example7 {

        public static void main(String[] args) {
            int x = 0;
//            System.out.println(x++);
//            System.out.println(++x);

            System.out.println(x++ == ++x);
        }
    }

    static class Example8 {

        /**
         * Данная операция появилась в более поздних версиях java и для того, чтобы не поломать обратную совместимость,
         * используется не в первую очередь
         * Используя int... не беспокоимся, что нужно передавать массив, а просто передаём столько переменных,
         * сколько нам нужно
         */
        static void method(int... a) {
            System.out.println("int");
        }

        static void method(long a, long b, long c) {
            System.out.println("long");
        }

        /**
         * Не вызывается, т.к. требуется операция боксинга и это довольго дорогостоящая операция
         */
        static void method(Integer a, Integer b, Integer c) {
            System.out.println("Integer");
        }

        /**
         * Не скомпилируется, т.к. массив переменной длины (int...) должен стоять в конце
         */
//        static void method(int...a, int b, int c){
//            System.out.println("int2");
//        }
        static void method(int a, int b, int... c) {
            System.out.println("int2");
        }

        public static void main(String[] args) {
            int a = 1;
            int b = 1;
            int c = 1;
            method(a, b, c);
        }
    }

    static class Example9 {

        /**
         * Примитивные типы инициализуются 0, булеан - false, char -  символ
         * Ссылочные типы инициализируются null;
         */
        String str;
        int i;
        Double d;
        Boolean b;
        boolean bool;
        char symbol;

        public static void main(String[] args) {
            String str;
            Example9 example9 = new Example9();
            System.out.println(example9.str);
            System.out.println(example9.i);
            System.out.println(example9.d);
            System.out.println(example9.b);
            System.out.println(example9.bool);
            System.out.println(example9.symbol);
            /**
             * Чтобы использовать переменные внутри метода, они должны быть проинициализированы
             * */
//            System.out.println(str);
        }
    }

    static class Example11 {

        /**
         * Такой код не скомпилируется, потому что перегрузка методов допускается только с разными принимаемыми аргументами.
         * В текущем варианте jvm не поймёт что вызывать
         *
         * */

//        int info(){
//            return 5;
//        }
//        String info(){
//            return "String";
//        }
//
//        public static void main(String[] args) {
//            System.out.println(new Example11().info());
//        }
//    }
}

}