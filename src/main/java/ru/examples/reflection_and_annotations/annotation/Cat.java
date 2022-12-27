package ru.examples.reflection_and_annotations.annotation;


@AppTable(title = "cats")
public class Cat {
    @AppField
    private int id;
    @AppField
    private String name;
    private int version;
}
