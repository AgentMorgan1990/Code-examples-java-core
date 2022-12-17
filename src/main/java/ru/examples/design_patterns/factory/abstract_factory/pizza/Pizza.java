package ru.examples.design_patterns.factory.abstract_factory.pizza;

import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.cheese.Cheese;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.clams.Clams;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.dough.Dough;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.peperoni.Pepperoni;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.sauce.Sauce;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.veggies.Veggies;

public abstract class Pizza {
    String name;
    Dough dough;
    Sauce sauce;
    Veggies veggies[];
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clams;

    abstract void prepare();

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
