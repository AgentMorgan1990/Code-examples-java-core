package ru.examples.design_patterns.factory.abstract_factory;

import ru.examples.design_patterns.factory.abstract_factory.pizza.Pizza;
import ru.examples.design_patterns.factory.abstract_factory.pizza_store.ChicagoPizzaStore;
import ru.examples.design_patterns.factory.abstract_factory.pizza_store.NYPizzaStore;
import ru.examples.design_patterns.factory.abstract_factory.pizza_store.PizzaStore;

public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyPizzaStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyPizzaStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza("clam");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");

    }
}
