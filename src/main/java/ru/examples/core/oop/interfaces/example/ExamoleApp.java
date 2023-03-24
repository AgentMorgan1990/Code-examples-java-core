package ru.examples.core.oop.interfaces.example;

import ru.examples.core.oop.interfaces.example.barriers.Barrier;
import ru.examples.core.oop.interfaces.example.barriers.RunningTrack;
import ru.examples.core.oop.interfaces.example.barriers.Wall;
import ru.examples.core.oop.interfaces.example.competitors.Cat;
import ru.examples.core.oop.interfaces.example.competitors.Human;
import ru.examples.core.oop.interfaces.example.competitors.Overcoming;

import java.util.List;

/**
 * 1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти
 * классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в
 * консоль).
 *
 * 2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники
 * должны выполнять соответствующие действия (бежать или прыгать), результат выполнения
 * печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
 *
 * 3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти
 * этот набор препятствий.
 *
 * 4. * У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения
 * на бег и прыжки. Если участник не смог пройти одно из препятствий, то дальше по списку он
 * препятствий не идет.
 *
 */


public class ExamoleApp {

    public static void main(String[] args) {
        Human human = new Human("John", 20.6, 3.7);
        Cat cat = new Cat("Barsic", 30.5, 10.7);

        Wall firstWall = new Wall(2.5);
        Wall secondWall = new Wall(6.8);
        RunningTrack firstRunningTrack = new RunningTrack(15.8);
        RunningTrack secondRunningTrack = new RunningTrack(25.7);

        List<Barrier> barriers = List.of(firstWall, firstRunningTrack, secondWall, secondRunningTrack);
        List<Overcoming> competitors = List.of(human, cat);

        for (Overcoming competitor:competitors) {
            competitor.overcome(barriers);
        }

    }
}
