package tests.entities;

import entities.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Examples;
import utils.Global;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class ControleAcademicoTest {

    private Aluno aluno;
    private Professor professor;
    private Turma turma;

    private ControleAcademico controleAcademico;

    @BeforeEach
    public void setUp () {
        this.controleAcademico = Global.getControleAcademico();

        List<Professor> professores = Examples.obterProfessores();
        List<Aluno> alunos = Examples.obterAlunos();
        List<Turma> turmas = Examples.obterTurmas();

        controleAcademico.setAlunos(alunos);
        controleAcademico.setTurmas(turmas);
        controleAcademico.setProfessores(professores);

        this.aluno = alunos.get(0);
        this.professor = professores.get(0);
        this.turma = turmas.get(0);
    }

    @Test
    public void testObterProfessorPorMatricula() {

        assertEquals(
                professor,
                controleAcademico.obterProfessorPorMatricula(professor.getMatricula())
        );

    }

    @Test
    public void testVerificarHorarioEmUso() {
       Horario horario = controleAcademico
               .getTurmas()
               .get(0)
               .getHorarios()
               .get(0);

       assertTrue(controleAcademico.verificarHorarioEmUso(horario));
    }

    @Test
    public void testObterTurmasDeUmAluno() {
        assertEquals(aluno.getTurmas(), controleAcademico.obterTurmasDeUmAluno(aluno));
    }

}
