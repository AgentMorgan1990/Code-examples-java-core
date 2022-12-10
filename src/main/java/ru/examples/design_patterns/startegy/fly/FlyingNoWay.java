package ru.examples.design_patterns.startegy.fly;

public class FlyingNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
