package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import sanduiche.Sanduiche;
import sanduicheFactory.SanduicheDePresuntoDePapaiLulinha;
import sanduicheFactory.SanduicheDePresuntoDoChavesFactory;
import sanduicheFactory.SanduicheFactory;
import sanduicheFactory.SanduicheicheDeFrango;

public class SanduicheFactoryTest {

    @Test
    public void testSanduicheDePresuntoDePapaiLulinha() {
        SanduicheFactory factory = new SanduicheDePresuntoDePapaiLulinha();
        Sanduiche sanduiche = factory.criarSanduiche();

        assertEquals("Pão Francês", sanduiche.getPao().getTipo());
        assertEquals("Queijo Cheddar", sanduiche.getQueijo().getTipo());
        assertEquals("Presunto de Frango", sanduiche.getPresunto().getTipo());
        assertEquals("Ovo de Capoeira", sanduiche.getOvo().getTipo());
        assertEquals("Tomate", sanduiche.getTomate().getTipo());
    }

    @Test
    public void testSanduicheicheDeFrango() {
        SanduicheFactory factory = new SanduicheicheDeFrango();
        Sanduiche sanduiche = factory.criarSanduiche();

        assertEquals("Pão Bola", sanduiche.getPao().getTipo());
        assertEquals("Queijo Prato", sanduiche.getQueijo().getTipo());
        assertEquals("Presunto de Frango", sanduiche.getPresunto().getTipo());
        assertEquals("Ovo de Granja", sanduiche.getOvo().getTipo());
        assertEquals("Tomate", sanduiche.getTomate().getTipo());
    }

    @Test
    public void SanduicheDePresuntoDoChavesFactory() {
        SanduicheFactory factory = new SanduicheDePresuntoDoChavesFactory();
        Sanduiche sanduiche = factory.criarSanduiche();

        assertEquals("Pão Francês", sanduiche.getPao().getTipo());
        assertEquals("Queijo Mussarela", sanduiche.getQueijo().getTipo());
        assertEquals("Presunto de Peru", sanduiche.getPresunto().getTipo());
        assertEquals("Ovo de Granja", sanduiche.getOvo().getTipo());
        assertEquals("Tomate", sanduiche.getTomate().getTipo());
    }

}

