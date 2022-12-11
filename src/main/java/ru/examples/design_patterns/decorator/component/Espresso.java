package ru.examples.design_patterns.decorator.component;

public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double coast() {
        return 1.99;
    }
}
