package ru.examples.core.base_constructions;

/**
 * Как только загружается класс UseStatic, выполняются все статические операторы. Сначала в переменной а устанавливается
 * значение З, затем выполняется статический блок кода, в котором выводится сообщение, а переменная Ь инициализируется
 * значением а* 4, т.е. 12. После этого вызывается метод main ( ) , который, в свою очередь, вызывает метод me th () ,
 * передавая параметру х значение 42.
 * В трех вызовах метода println () делаются ссылки на две статические переменные, а и Ь, а также на локальную переменную х .
 */

public class TestStatic {

    static int a = 3;
    static int b;

    static void meth(int x) {
        System.out.println("x = " + x);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    static {
        System.out.println("Cтaтичecкий блок инициализирован.");
        b = a * 4;
    }

    public static void main(String[] args) {
        meth(42);
    }

}
