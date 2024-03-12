package tests.entities;

import entities.Professor;
import entities.Turma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProfessorTest {

    private Professor professor;
    private Turma turma;

    @BeforeEach
    public void setUp() {
        this.professor = new Professor("Carlos", "Silveira");
        this.turma = new Turma("CPT01093", "PARADIGMAS DE PROGRAMAÇÃO", 60);
    }

    @Test
    public void testarProfessorNaTurma() {
        professor.addTurma(turma);

        assertEquals(1, professor.getTurmas().size());
    }
    @Test
    public void testarAdicionarProfessorRepetido() {
        professor.addTurma(turma);

        assertThrows(
                IllegalArgumentException.class,
                () -> professor.addTurma(turma)
        );
    }
    
    
}
