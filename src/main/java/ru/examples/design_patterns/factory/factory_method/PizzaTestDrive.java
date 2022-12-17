package ru.examples.design_patterns.factory.factory_method;

import ru.examples.design_patterns.factory.factory_method.pizza.Pizza;
import ru.examples.design_patterns.factory.factory_method.pizza_store.ChicagoPizzaStore;
import ru.examples.design_patterns.factory.factory_method.pizza_store.NYPizzaStore;
import ru.examples.design_patterns.factory.factory_method.pizza_store.PizzaStore;

public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyPizzaStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyPizzaStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");

    }
}
