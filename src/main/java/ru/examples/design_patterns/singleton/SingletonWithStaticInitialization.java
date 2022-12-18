package ru.examples.design_patterns.singleton;

public class SingletonWithStaticInitialization {
    private static SingletonWithStaticInitialization uniqueInstance = new SingletonWithStaticInitialization();

    private SingletonWithStaticInitialization() {
    }

    public static synchronized SingletonWithStaticInitialization getInstance() {
        return uniqueInstance;
    }

    //Остальные методы класса
}
