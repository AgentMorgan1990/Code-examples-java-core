package ru.examples.design_patterns.decorator.condiment_decorator;

import ru.examples.design_patterns.decorator.component.Beverage;

public abstract class CondimentDecorator extends Beverage {

    Beverage beverage;

    public abstract String getDescription();

}
