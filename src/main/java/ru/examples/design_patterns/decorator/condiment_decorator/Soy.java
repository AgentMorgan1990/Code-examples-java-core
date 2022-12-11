package ru.examples.design_patterns.decorator.condiment_decorator;

import ru.examples.design_patterns.decorator.component.Beverage;

public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double coast() {
        return beverage.coast() + 0.15;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " ,Soy ";
    }
}
