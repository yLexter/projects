package tests.entities;

import entities.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FuncionarioTest {

    private Funcionario funcionario;

    @BeforeEach
    public void setUp() {
        funcionario = null;
    }

    @Test
    public void testCriarFuncionarioComNomeNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            funcionario = new Funcionario(null, "Santos");
        });
        assertNull(funcionario);
    }

    @Test
    public void testCriarFuncionarioComSobrenomeNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            funcionario = new Funcionario("Maria", null);
        });
        assertNull(funcionario);
    }

    @Test
    public void testCriarFuncionarioComNomeESobrenomeNulos() {
        assertThrows(IllegalArgumentException.class, () -> {
            funcionario = new Funcionario(null, null);
        });
        assertNull(funcionario);
    }

    @Test
    public void testCriarFuncionarioComNomeESobrenomeValidos() {
        funcionario = new Funcionario("José", "Silva");
        assertNotNull(funcionario);
        assertEquals("José", funcionario.getNome());
        assertEquals("Silva", funcionario.getSobrenome());
    }

}
