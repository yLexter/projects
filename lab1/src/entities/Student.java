package entities;

import entities.enums.Role;

import java.util.*;

/**
 * Esta classe representa um estudante, que é um tipo de funcionário do sistema.
 * Um estudante possui informações adicionais, como as disciplinas em que está matriculado,
 * o curso em que está inscrito, o histórico acadêmico e o resultado do vestibular.
 */

public class Student extends Employee {
    private List<String> collegeClasses;
    private String course;
    private List<SubjectStudent> historic;

    public Student(String name, String lastName, int age, String course) {
        super(name, lastName, Role.STUDENT, age);
        this.course = course;
        this.collegeClasses = new ArrayList<>();
        this.historic = new ArrayList<>();
    }
  

}
