package ru.examples.design_patterns.factory.abstract_factory.ingredient_factory;

import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.cheese.Cheese;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.cheese.MozzarellaCheese;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.clams.Clams;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.clams.FrozenClams;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.dough.Dough;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.dough.ThinCrustDough;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.peperoni.Pepperoni;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.peperoni.SlicedPepperoni;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.sauce.PlumTomatoSauce;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.sauce.Sauce;
import ru.examples.design_patterns.factory.abstract_factory.ingredient_factory.veggies.*;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory{
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = {new BlackOlives(),new Eggplant(), new Spinach()};
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FrozenClams();
    }
}
