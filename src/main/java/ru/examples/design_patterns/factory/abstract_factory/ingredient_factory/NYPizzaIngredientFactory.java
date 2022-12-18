package ru.examples.design_patterns.factory.abstract_factory.ingredient_factory;

import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.cheese.Cheese;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.cheese.ReggianoCheese;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.clams.Clams;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.clams.FreshClams;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.dough.Dough;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.dough.ThinCrustDough;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.peperoni.Pepperoni;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.peperoni.SlicedPepperoni;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.sauce.MarinaraSauce;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.sauce.Sauce;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.veggies.Garlic;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.veggies.Mushroom;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.veggies.Onion;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.veggies.Veggies;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory{
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = {new Garlic(),new Onion(), new Mushroom()};
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FreshClams();
    }
}
