package ru.examples.design_patterns.factory.factory_method.pizza_store;

import ru.examples.design_patterns.factory.factory_method.pizza.Pizza;

public abstract class PizzaStore {

    public Pizza orderPizza(String type){
        Pizza pizza;
        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
    //Абстрактный фабричный метод
    protected abstract Pizza createPizza(String type);
}
