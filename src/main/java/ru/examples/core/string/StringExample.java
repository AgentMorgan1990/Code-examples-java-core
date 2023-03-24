package ru.examples.core.string;


import java.nio.charset.StandardCharsets;


public class StringExample {



    //todo добавть варианты со стрингформат
    //todo примеры работы стрингбилдера
    //todo примеры работы методов класса стринг
    public static void main(String[] args) {
//        compareString();
//       createString();
//       concatString();
//       concatInt1();
//       concatInt2();
//useIntern();
        useStringMethods();
//        useStringBuilder();


    }


    private static void compareString() {
        String a = "Java";                      // тут строка попадает в стрингпул
        String b = "Java";                      // поскольку такая строка уже есть в стрингпуле, копируется ссылка на неё
        String c = new String("Java");  //  тут принудительно выделяем память в хипе
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
    }

    private static void useIntern(){
        String a1 = "A";
        String a2 = new String("A");
        System.out.println(a1 == a2);
        String a3 = a2.intern();            // Возвращает строку, которая имеет то же содержимое, что и эта строка, но гарантированно принадлежит к пулу уникальных строк.
        System.out.println(a1 == a2);
        System.out.println(a1 == a3);
    }

    private static void createString() {
        String s1 = "Java";
        String s2 = new String("Home");
        String s3 = new String(new char[]{'A', 'B', 'C'});
        String s4 = new String(s3);
        String s5 = new String(new byte[]{65, 66, 67}); //Если кодировка не указана, будет использована ASCII.
        String s6 = new String(new byte[]{0, 65, 0, 66}, StandardCharsets.UTF_16);
        System.out.printf("s1 = %s, s2 = %s, s3 = %s, s4 = %s, s5 = %s, s6 = %s", s1, s2, s3, s4, s5, s6);
    }

    private static void concatString(){
        String a1 = "Hello ";
        String a2 = "World";
        String a3 = a1 + a2;
        System.out.println(a3);
        String b1 = "Число 10: ";
        int b2 = 10;
        String b3 = b1 + b2;
        System.out.println(b3);
        String c1 = "Home";
        String c2 = "[" + c1 + "] = " + 1;
        System.out.println(c2);
    }

    /**
     * В данном примере выполняются операции добавления двух интов, преобразованных в стринг
     * */
    private static void concatInt1(){
        String str = "Десять: " + 5 + 5;
        System.out.println(str);
    }

    /**
     * В данном примере инты сначала складываются, а только потом преобразуются в строку
     * */
    private static void concatInt2(){
        String str = "Десять: " + (5 + 5);
        System.out.println(str);
    }


    //todo можно открыть документашку по стринге, чтобы идти по порядку, проработать все методы
    private static void useStringMethods(){
        String str = "I love Java";
        String str1 = "I LOVE JAVA";
        String str2 = "     ";

        System.out.println(str.charAt(4));                                          // Returns the char value at the specified index.
        str.chars().forEach(c-> System.out.println("Код char в stream " + c));      // Returns a stream of int zero-extending the char values from this sequence.
        System.out.println("codePointAt " + str.codePointAt(0));              // Returns the character (Unicode code point) at the specified index.
        char a = 73;
        System.out.println(a);
        System.out.println("codePointBefore " + str.codePointBefore(1));      // Returns the character (Unicode code point) before the specified index. Печатает код чара перед переданным индесом




        System.out.println("Длина строки " + str.length());                               // длина строки

        System.out.println(str.indexOf('l'));                           // индекс по символу
        System.out.println(str.getBytes());                             // перевести в байты, обычно для отправки через сеть
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());
        System.out.println(str.compareToIgnoreCase(str1));              // сравнение с игнорированием кейса
        System.out.println(str.endsWith("va"));                         // проверка окончивается ли на набор символов
        System.out.println(str.lastIndexOf("a"));                   // получить последнее совпадение индекса
        System.out.println(str2.isBlank());                             // проверка есть ли символы
        System.out.println(str2.isEmpty());                             // проверка пустая ли строка

    }


    private static void useStringBuilder(){

        char[] arr = new char[]{'A','B','C'};
        StringBuilder sb = new StringBuilder(25);
        StringBuilder sb1 = new StringBuilder("Java");
        sb.append("AB");
        String finishString = sb.toString();
        System.out.println(finishString);

        sb.reverse();                       // Развернуть в обратную сторону
        System.out.println(sb);

        sb.setCharAt(0,'5');      // Заменить символ по индексу на чар
        System.out.println(sb);

    }
}

