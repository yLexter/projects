package tests.entities;

import entities.ControleAcademico;
import entities.Horario;
import entities.Professor;
import entities.Turma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Global;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProfessorTest {

    private Professor professor;

    private Turma turma;

    private ControleAcademico controleAcademico = Global.getControleAcademico();

    @BeforeEach
    public void setUp() {
        ControleAcademico.setarBancoDeDados();

        this.professor = new Professor("Carlos", "Silveira");
        this.turma = new Turma("CPT01093", "PARADIGMAS DE PROGRAMAÇÃO", 60);
    }

    @Test
    public void testarHorariosProfessor() {
        List<Horario> horario = new ArrayList<>();

        Turma t1 = controleAcademico.getTurmas().get(0);
        Turma t2 = controleAcademico.getTurmas().get(1);

        horario.addAll(t1.getHorarios());
        horario.addAll(t2.getHorarios());

        professor.addTurma(t1);
        professor.addTurma(t2);

        assertEquals(horario, professor.getHorario());

    }

}
