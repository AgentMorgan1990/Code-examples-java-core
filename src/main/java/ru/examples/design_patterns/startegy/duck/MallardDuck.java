package ru.examples.design_patterns.startegy.duck;

import ru.examples.design_patterns.startegy.fly.FlyWithWings;
import ru.examples.design_patterns.startegy.quack.Quack;

public class MallardDuck extends Duck{

    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }
    @Override
    public void display() {
        System.out.println("I'm real Mallard duck");
    }
}
