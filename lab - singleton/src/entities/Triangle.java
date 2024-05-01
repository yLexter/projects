package entities;

import enums.TriangleKind;
import erros.Figura2DException;
import erros.SingletonException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Triangle extends Figura2D {

    private HashMap<TriangleKind, Triangle> instancias;

    public int MAXIMO_TRIANGULOS = 3;

    private double side1;
    private double side2;
    private double side3;

    private Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        if (allSidesAreZero() || hasImpossibleSides() || violatesTriangleInequality()) {
            throw new Figura2DException();
        }

    }

    public TriangleKind getKind() {
        int uniqueSides = getNumberOfUniqueSides();

        if (uniqueSides == 1) {
            return TriangleKind.EQUILATERAL;
        }

        if (uniqueSides == 2) {
            return TriangleKind.ISOSCELES;
        }

        return TriangleKind.SCALENE;
    }

    private boolean allSidesAreZero() {
        return side1 == 0 && side2 == 0 && side3 == 0;
    }

    private boolean hasImpossibleSides() {
        return side1 < 0 || side2 < 0 || side3 < 0;
    }

    private boolean violatesTriangleInequality() {
        return side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1;
    }

    public int getNumberOfUniqueSides() {
        Set<Double> sides = new HashSet<>();

        sides.add(side1);
        sides.add(side2);
        sides.add(side3);

        return sides.size();
    }

    public Triangle getInstancia(TriangleKind tipoTriangulo) {
        return instancias.get(tipoTriangulo);
    }

    public Triangle criarInstancia(double side1, double side2, double side3) {

        if (instancias.size() == MAXIMO_TRIANGULOS) {
            throw new SingletonException("Já possui %d triangulos".formatted(MAXIMO_TRIANGULOS));
        }

        Triangle triangulo = new Triangle(side1, side2, side3);
        TriangleKind tipoTriangulo = triangulo.getKind();

        if (instancias.containsKey(tipoTriangulo)) {
            throw new SingletonException("Não é possivel triangulos com o mesmo tipo 2x");
        }

        instancias.put(tipoTriangulo, triangulo);

        return triangulo;
    }

    @Override
    public double getPerimetro() {
        return side1 + side2 + side3;
    }

    @Override
    public double getArea() {
        double s = getPerimetro() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

}