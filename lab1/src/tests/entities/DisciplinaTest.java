package tests.entities;

import entities.Disciplina;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DisciplinaTest {

    @Test
    public void testCriarDisciplinaComCodigoNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
             new Disciplina(null, "Matemática", 60);
        });
    }

    @Test
    public void testCriarDisciplinaComNomeNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
             new Disciplina("MAT123", null, 60);
        });
    }

    @Test
    public void testCriarDisciplinaComCodigoENomeNulos() {
        assertThrows(IllegalArgumentException.class, () -> {
             new Disciplina(null, null, 60);
        });
    }

    @Test
    public void testCriarDisciplinaComHorasNegativas() {
        assertThrows(IllegalArgumentException.class, () -> {
             new Disciplina("MAT123", "Matemática", -10);
        });
    }


}
