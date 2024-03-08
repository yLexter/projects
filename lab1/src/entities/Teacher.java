package entities;

import entities.enums.Role;

public class Teacher extends Employee {

    public Teacher(String name, String lastName, int age) {
        super(name, lastName, Role.TEACHER, age);
    }

}

