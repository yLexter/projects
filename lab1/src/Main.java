import entities.*;
import labs.Lab1;
import utils.Examples;
import utils.Global;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Professor> professores = Examples.obterProfessores();
        List<Aluno> alunos = Examples.obterAlunos();
        List<Turma> turmas = Examples.obterTurmas();

        ControleAcademico controleAcademico = Global.getControleAcademico();

        controleAcademico.setAlunos(alunos);
        controleAcademico.setTurmas(turmas);
        controleAcademico.setProfessores(professores);

        new Lab1().run();
    }


}