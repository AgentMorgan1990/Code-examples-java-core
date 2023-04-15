package ru.examples.core.base_constructions.methods;

public class Parent {


    //При перегрузке метода можно изменить тип возвращаемого значения, но аргументы или их кол-во должны отличаться

    public String add(String str){
        String str1 = str + 1;
        System.out.println(str1);
        return str1;
    }

    public void add(String str, String str2){
        System.out.println(str + str2 + 1);
    }

    public static void print (String str){
        System.out.println("Вызов в методе родителя");
    }




}
