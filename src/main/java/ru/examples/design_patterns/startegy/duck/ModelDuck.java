package ru.examples.design_patterns.startegy.duck;

import ru.examples.design_patterns.startegy.fly.FlyingNoWay;
import ru.examples.design_patterns.startegy.quack.Quack;

public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new FlyingNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
