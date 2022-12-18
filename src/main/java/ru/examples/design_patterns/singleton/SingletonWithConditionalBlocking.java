package ru.examples.design_patterns.singleton;

public class SingletonWithConditionalBlocking {
    private volatile static SingletonWithConditionalBlocking uniqueInstance;

    private SingletonWithConditionalBlocking() {
    }

    public static SingletonWithConditionalBlocking getInstance() {
        if (uniqueInstance == null) {
            synchronized (SingletonWithConditionalBlocking.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new SingletonWithConditionalBlocking();
                }
            }
        }
        return uniqueInstance;
    }
    //Остальные методы класса
}
