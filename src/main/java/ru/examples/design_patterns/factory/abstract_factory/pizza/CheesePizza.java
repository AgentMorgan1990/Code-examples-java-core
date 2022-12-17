package ru.examples.design_patterns.factory.abstract_factory.pizza;

import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.PizzaIngredientFactory;

public class CheesePizza extends Pizza {
    PizzaIngredientFactory pizzaIngredientFactory;
    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.pizzaIngredientFactory =ingredientFactory;
    }


    @Override
    void prepare() {
        System.out.println("Preparing "+ name);
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();
    }

}
