package ru.examples.design_patterns.decorator.condiment_decorator;

import ru.examples.design_patterns.decorator.component.Beverage;

public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double coast() {
        return beverage.coast() + 0.20;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " , Mocha";
    }
}
