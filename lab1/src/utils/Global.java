package utils;

import entities.ControleAcademico;

import java.util.Scanner;

public class Global {

    private static ControleAcademico controleAcademico;

    private static Scanner scanner;

    public static Scanner getScanner() {
        if (scanner != null) return scanner;
        return scanner = new Scanner(System.in);
    }

    public static ControleAcademico getControleAcademico() {
        if (controleAcademico != null) return controleAcademico;
        return controleAcademico = new ControleAcademico();
    }
}
