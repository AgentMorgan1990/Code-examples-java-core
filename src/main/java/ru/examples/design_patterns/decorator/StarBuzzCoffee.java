package ru.examples.design_patterns.decorator;

import ru.examples.design_patterns.decorator.component.Beverage;
import ru.examples.design_patterns.decorator.component.DarkRoast;
import ru.examples.design_patterns.decorator.component.Espresso;
import ru.examples.design_patterns.decorator.condiment_decorator.Mocha;
import ru.examples.design_patterns.decorator.condiment_decorator.Whip;

/**
 * Пример использования Декоратора
 *
 * Напиток (Beverage) - абстрактный класс компонента
 *
 * HouseBlend, Espresso, DarkRoast - конкретные компоненты
 *
 * CondimentDecorator - абстрактный декоратор
 *
 * Mocha, Soy, Whip - конкретные реализации декоратора CondimentDecorator
 *
 * Расширяем/декорируем напиток (Beverage) приправами с помощью абстрактного класса приправ (CondimentDecorator)
 *
 * */

//todo добавить схему классов для понимания
//todo добавить второй пример с inputStream
//todo решить задачу на добавление размеров кофе

public class StarBuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.coast());

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.coast());

    }
}
