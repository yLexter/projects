package tests.visitors;

import entities.*;
import visitors.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class VisitorCalculaAreaTest {

    @Test
    public void testCalculaAreaCirculo() {
        Circulo circulo = new Circulo(5.0);
        VisitorCalculaArea visitor = new VisitorCalculaArea();
        double area = visitor.visitaCirculo(circulo);
        assertEquals(Math.PI * 25.0, area, 1e-6);
    }

    @Test
    public void testCalculaAreaTriangulo() {
        Triangle triangulo = new Triangle(3.0, 4.0, 5.0);
        VisitorCalculaArea visitor = new VisitorCalculaArea();
        double area = visitor.visitaTriangulo(triangulo);
        assertEquals(6.0, area, 1e-6);
    }

    @Test
    public void testCalculaAreaRetangulo() {
        Retangulo retangulo = new Retangulo(6.0, 8.0);
        VisitorCalculaArea visitor = new VisitorCalculaArea();
        double area = visitor.visitaRetangulo(retangulo);
        assertEquals(48.0, area, 1e-6);
    }

}
