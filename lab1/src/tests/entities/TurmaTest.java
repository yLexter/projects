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

import static org.junit.jupiter.api.Assertions.*;

public class TurmaTest {

    private Aluno aluno;

    private Turma turma;

    public Horario horario;

    private ControleAcademico controleAcademico = Global.getControleAcademico();

    @BeforeEach
    public void setUp () {
        List<Professor> professores = Examples.obterProfessores();
        List<Aluno> alunos = Examples.obterAlunos();
        List<Turma> turmas = Examples.obterTurmas();

        controleAcademico.setAlunos(alunos);
        controleAcademico.setTurmas(turmas);
        controleAcademico.setProfessores(professores);

        this.turma = turmas.get(0);
        this.horario = new Horario("1vB4", "ID_Turma");
        this.aluno = new Aluno("João", "Silva");
    }

    @Test
    public void testAdicionarAluno() {
        turma.adicionarAluno(aluno);

        assertEquals(3, turma.getTotalDeAluno());
        assertEquals(1, aluno.getTurmas().size());

        assertThrows(
                IllegalArgumentException.class,
                () -> turma.adicionarAluno(aluno)
        );
    }

    @Test
    public void testAdicionarHorarioRepetido() {
        turma.adicionarHorario(horario);

        assertThrows(
                IllegalArgumentException.class,
                () -> turma.adicionarHorario(horario)
        );
    }


}
