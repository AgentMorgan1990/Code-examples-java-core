package ru.examples.design_patterns.factory.factory_method.pizza_store;

import ru.examples.design_patterns.factory.factory_method.pizza.ChicagoStyleCheesePizza;
import ru.examples.design_patterns.factory.factory_method.pizza.Pizza;

public class ChicagoPizzaStore extends PizzaStore {
    //конкретный фабричный метод
    @Override
    protected Pizza createPizza(String item) {
        if (item.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
//        } else if (item.equals("veggie")) {
//            return new ChicagoStyleVeggiePizza();
//        } else if (item.equals("clam")) {
//            return new ChicagoStyleClamPizza();
//        } else if (item.equals("peperoni")) {
//            return new ChicagoStylePeperoniPizza();
        } else return null;
    }
}

