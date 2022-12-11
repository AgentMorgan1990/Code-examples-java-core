package ru.examples.design_patterns.decorator.component;

public abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double coast();
}
