package ru.examples.design_patterns.decorator.condiment_decorator;

import ru.examples.design_patterns.decorator.component.Beverage;

public class Whip extends CondimentDecorator {

        public Whip(Beverage beverage) {
                this.beverage = beverage;
        }

        @Override
        public double coast() {
                return beverage.coast() + 0.10;
        }

        @Override
        public String getDescription() {
                return beverage.getDescription() + " ,Whip ";
        }
}
