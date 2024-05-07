package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import entities.Quadrado;
import erros.Figura2DException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuadradoTest {

    private Quadrado quadrado;

    @Before
    public void setUp() {
        quadrado = new Quadrado(5.0); // Criando uma instância do quadrado antes de cada teste
    }

    @After
    public void tearDown() {
        quadrado = null; // Destruindo a instância do quadrado após cada teste
    }

    @Test
    public void testGetLado() {
        assertEquals(5.0, quadrado.getLado(), 0.0001); // Verificando se o lado do quadrado é 5.0
    }

    @Test
    public void testSetLado() {
        quadrado.setLado(10.0); // Alterando o lado do quadrado para 10.0
        assertEquals(10.0, quadrado.getLado(), 0.0001); // Verificando se o lado do quadrado foi alterado corretamente
    }

    @Test
    public void testGetArea() {
        assertEquals(25.0, quadrado.getArea(), 0.0001); // Verificando se a área do quadrado é 25.0
    }

    @Test
    public void testGetNome() {
        assertEquals("Quadrado", quadrado.getNome()); // Verificando se o nome do quadrado é "Quadrado"
    }

    @Test
    public void testGetPerimetro() {
        assertEquals(20.0, quadrado.getPerimetro(), 0.0001); // Verificando se o perímetro do quadrado é 20.0
    }

    @Test(expected = Figura2DException.class)
    public void testLadoNegativo() {
        Quadrado quadradoNegativo = new Quadrado(-5.0); // Tentando criar um quadrado com lado negativo, deve lançar Figura2DException
    }
}

