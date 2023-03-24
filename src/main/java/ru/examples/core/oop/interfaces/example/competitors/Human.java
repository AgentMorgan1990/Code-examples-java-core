package ru.examples.core.oop.interfaces.example.competitors;

import ru.examples.core.oop.interfaces.example.barriers.Barrier;
import ru.examples.core.oop.interfaces.example.barriers.RunningTrack;
import ru.examples.core.oop.interfaces.example.barriers.Wall;

import java.util.List;

public class Human implements Runnable, Jumpable, Overcoming {

    private String name;
    private double maxSpeed;
    private double maxHeight;

    public Human(String name, double maxSpeed, double maxHeight) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean jump(Wall wall) {
        if (wall.getHeight() > maxHeight) {
            System.out.println("Человек " + name + " не смог перепрыгнуть");
            return false;
        } else {
            System.out.println("Человек " + name + " прыгнул");
            return true;
        }
    }

    @Override
    public boolean run(RunningTrack runningTrack) {
        if (runningTrack.getSpeed() > maxSpeed) {
            System.out.println("Человек " + name + " не смог пробежать");
            return false;
        } else {
            System.out.println("Человек " + name + " пробежал");
            return true;
        }
    }

    @Override
    public void overcome(List<Barrier> barriers) {
        for (Barrier barrier : barriers) {

            boolean isOvercome = false;

            if (barrier instanceof Wall) {
                isOvercome = this.jump((Wall) barrier);
            }

            if (barrier instanceof RunningTrack) {
                isOvercome = this.run((RunningTrack) barrier);
            }

            if (!isOvercome) break;
        }
    }
}
