package entities;

import erros.Figura2DException;
import interfaces.IAceitaVisitor;
import interfaces.IVisitor;

public class Retangulo extends Figura2D implements IAceitaVisitor {
    private double ladoA;
    private double ladoB;

    public Retangulo(double ladoA, double ladoB) throws IllegalArgumentException {
        if (ladoA <= 0 || ladoB <= 0) {
            throw new Figura2DException("Os lados do retângulo devem ser maiores que zero.");
        }

        this.ladoA = ladoA;
        this.ladoB = ladoB;
    }

    public double getLadoA() {
        return ladoA;
    }

    public void setLadoA(double ladoA) {
        if (ladoA <= 0) {
            throw new Figura2DException("Os lados do retângulo devem ser maiores que zero.");
        }

        this.ladoA = ladoA;
    }

    public double getLadoB() {
        if (ladoA <= 0) {
            throw new Figura2DException("Os lados do retângulo devem ser maiores que zero.");
        }

        return ladoB;
    }

    public void setLadoB(double ladoB) {
        this.ladoB = ladoB;
    }

    @Override
    public String getNome() {
        return "Retângulo";
    }

    @Override
    public Double aceitarVisitor(IVisitor visitor) {
        return visitor.visitaRetangulo(this);
    }

    @Override
    public String toString() {
        return "%s [Lados: %.2f, %.2f]".formatted(
                super.toString(),
                ladoA,
                ladoB
        );
    }


}