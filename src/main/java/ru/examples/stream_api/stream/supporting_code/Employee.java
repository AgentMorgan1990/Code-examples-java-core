package ru.examples.stream_api.stream.supporting_code;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private String firstName;
    private String lastName;
    private int id;
    private int age;
    private Position position;
}
