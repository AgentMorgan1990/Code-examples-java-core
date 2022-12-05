package ru.examples.design_patterns.startegy;

import ru.examples.design_patterns.startegy.duck.Duck;
import ru.examples.design_patterns.startegy.duck.MallardDuck;
import ru.examples.design_patterns.startegy.duck.ModelDuck;
import ru.examples.design_patterns.startegy.fly.FlyRocketPowered;

public class TestClass {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        System.out.println("<<<>>>");

        Duck model = new ModelDuck();
        model.performFly();
        model.performQuack();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
