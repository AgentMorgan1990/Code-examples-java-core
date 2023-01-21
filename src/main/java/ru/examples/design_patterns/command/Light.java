package ru.examples.design_patterns.command;

public class Light {
    String roomName;

    public Light(String roomName) {
        this.roomName = roomName;
    }

    public void on() {
        System.out.println("Light is on in " + roomName);
    }

    public void off() {
        System.out.println("Light is off in " + roomName);
    }
}



