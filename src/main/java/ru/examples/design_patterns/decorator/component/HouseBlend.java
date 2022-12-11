package ru.examples.design_patterns.decorator.component;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double coast() {
        return 0.89;
    }
}
