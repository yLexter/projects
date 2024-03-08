package entities;

import entities.enums.Role;

import java.security.SecureRandom;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Essa classe representa um funcionário. Ela contém informações como nome, sobrenome, CPF, data de nascimento, ID,
 * papel (role) e senha.
 */
public class Employee {
    public static final int sizeId = 8;
    private String name;
    private String lastName;
    private String id;
    private Role role;
    private String password;
    private int age;

    /**
     * Constrói um novo objeto Employee com as informações fornecidas.
     *
     * @param name         O nome do funcionário.
     * @param lastName     O sobrenome do funcionário.
     * @param role         O papel (role) do funcionário.
     */

    public Employee(String name, String lastName, Role role, int age) {
        this.name = name;
        this.lastName = lastName;
        this.role = role;
        this.age = age;
    }

}

