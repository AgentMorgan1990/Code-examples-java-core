package ru.examples.reflection_and_annotations.reflection;

public class ClassWithPrivateField {
    private int field;

    public ClassWithPrivateField(int field) {
        this.field = field;
    }

    public void info() {
        System.out.println("field: " + field);
    }
}
