package ru.examples.design_patterns.command;

public class Stereo {
    private int volume;

    public Stereo() {
    }

    public void on() {
        System.out.println("ЖЖЖЖ....");
    }

    public void setCD() {
        System.out.println("Диск, так диск");
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    public void off(){
        System.out.println("Решил поспать?");
    }
}
