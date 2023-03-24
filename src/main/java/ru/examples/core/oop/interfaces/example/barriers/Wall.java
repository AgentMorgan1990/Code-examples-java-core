package ru.examples.core.oop.interfaces.example.barriers;

public class Wall extends Barrier{
    private double height;

    public Wall(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }
}
