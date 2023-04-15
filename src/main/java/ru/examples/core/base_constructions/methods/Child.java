package ru.examples.core.base_constructions.methods;

public class Child extends Parent {


    //Можем перегрузить метод в наследнике и намбудут доступны все варианты перегрузки унаследника
    public void add(String str, String str2, String str3) {
        System.out.println(str + str2 + str3);
    }

    @Override
    public String add(String str) {
        return super.add(str);
    }

    //Перегружать статические методы нельзя, они по факту перекрывают родительские методы
//    @Override
    public static void print (String str){
        System.out.println("Вызов в методе наследника");
    }

    //Статические методы можно перегружать
    public static void print (String str, String str2){
        System.out.println(str + str2);
    }


}
