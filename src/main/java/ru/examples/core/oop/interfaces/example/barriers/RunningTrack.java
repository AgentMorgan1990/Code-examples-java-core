package ru.examples.core.oop.interfaces.example.barriers;

public class RunningTrack extends Barrier{
    private double speed;

    public RunningTrack(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }
}
