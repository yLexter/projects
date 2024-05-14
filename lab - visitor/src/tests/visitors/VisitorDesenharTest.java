package tests.visitors;

import entities.Circulo;
import entities.Retangulo;
import entities.Triangle;
import entities.Trapezio;
import interfaces.IVisitor;
import org.junit.jupiter.api.Test;
import visitors.VisitorDesenhar;

import static org.junit.jupiter.api.Assertions.*;

public class VisitorDesenharTest {

    @Test
    public void testDesenhaCirculo() {
        IVisitor visitor = new VisitorDesenhar();
        Circulo circulo = new Circulo(4.0);
        assertDoesNotThrow(() -> visitor.visitaCirculo(circulo));
    }

    @Test
    public void testDesenhaTriangulo() {
        IVisitor visitor = new VisitorDesenhar();
        Triangle triangulo = new Triangle(4.0, 4.0, 4.0);
        assertDoesNotThrow(() -> visitor.visitaTriangulo(triangulo));
    }

    @Test
    public void testDesenhaRetangulo() {
        IVisitor visitor = new VisitorDesenhar();
        Retangulo retangulo = new Retangulo(4.0, 6.0);
        assertDoesNotThrow(() -> visitor.visitaRetangulo(retangulo));
    }

    @Test
    public void testDesenhaTrapezio() {
        IVisitor visitor = new VisitorDesenhar();
        Trapezio trapezio = new Trapezio(4.0, 6.0, 2.0, 3.0, 4.0);
        assertDoesNotThrow(() -> visitor.visitaTrapezio(trapezio));
    }

    @Test
    public void testDesenhaFormaInvalida() {
        IVisitor visitor = new VisitorDesenhar();
        assertThrows(IllegalArgumentException.class, () -> visitor.visitaCirculo(null));
    }
}
