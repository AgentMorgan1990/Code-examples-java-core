package ru.examples.design_patterns.factory.abstract_factory.pizza_store;

import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.ChicagoPizzaIngredientFactory;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.PizzaIngredientFactory;
import ru.examples.design_patterns.factory.abstract_factory.pizza.CheesePizza;
import ru.examples.design_patterns.factory.abstract_factory.pizza.ClamPizza;
import ru.examples.design_patterns.factory.abstract_factory.pizza.Pizza;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String item) {
        Pizza pizza = null;
        PizzaIngredientFactory pizzaIngredientFactory = new ChicagoPizzaIngredientFactory();


        if (item.equals("cheese")) {
            pizza = new CheesePizza(pizzaIngredientFactory);
            pizza.setName("Chicago Style Cheese Pizza");
//        else if (item.equals("veggie")) {
//            pizza = new VeggiePizza(pizzaIngredientFactory);
//            pizza.setName("New York Style Veggie Pizza");
        } else if (item.equals("clam")) {
            pizza = new ClamPizza(pizzaIngredientFactory);
            pizza.setName("Chicago Style Clam Pizza");
        }
        return pizza;
    }
}

