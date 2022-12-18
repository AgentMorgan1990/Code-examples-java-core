package ru.examples.design_patterns.factory.abstract_factory.ingredient_factory;

import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.cheese.Cheese;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.clams.Clams;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.dough.Dough;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.peperoni.Pepperoni;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.sauce.Sauce;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.veggies.Veggies;

public interface PizzaIngredientFactory {
    public Dough createDough();

    public Sauce createSauce();

    public Cheese createCheese();

    public Veggies[] createVeggies();

    public Pepperoni createPepperoni();

    public Clams createClam();
}
