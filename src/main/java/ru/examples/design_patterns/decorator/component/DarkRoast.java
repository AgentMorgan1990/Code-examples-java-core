package ru.examples.design_patterns.decorator.component;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "Dark Roast Coffee";
    }

    @Override
    public double coast() {
        return 0.74;
    }
}
