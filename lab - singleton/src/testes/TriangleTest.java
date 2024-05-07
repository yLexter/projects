package testes;

import entities.Triangle;
import enums.TriangleKind;
import erros.Figura2DException;
import erros.SingletonException;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    @Test
    public void createValidTriangle() {
        Triangle triangle = Triangle.createInstance(3, 4, 5);
        assertNotNull(triangle);
        assertEquals(TriangleKind.RECTANGLE, triangle.getKind());
    }

    @Test
    public void createEquilateralTriangle() {
        Triangle triangle = Triangle.createInstance(6, 6, 6);
        assertNotNull(triangle);
        assertEquals(TriangleKind.EQUILATERAL, triangle.getKind());
    }

    @Test
    public void createTriangleWithNegativeSide() {
        assertThrows(Figura2DException.class, () -> Triangle.createInstance(-1, 2, 3));
    }

    @Test
    public void createTriangleWithZeroSide() {
        assertThrows(Figura2DException.class, () -> Triangle.createInstance(0, 2, 3));
    }

    @Test
    public void createTriangleWithImpossibleSides() {
        assertThrows(Figura2DException.class, () -> Triangle.createInstance(1, 1, 10));
    }

}
