package visitors;

import entities.Circulo;
import entities.Retangulo;
import entities.Trapezio;
import entities.Triangle;
import interfaces.IVisitor;

public class VisitorMaximizarFigura implements IVisitor {
    @Override
    public Double visitaCirculo(Circulo circulo) {
        // Duplicando o raio
        circulo.setRaio(circulo.getRaio() * 2);
        return null; // Não estamos retornando a área ou perímetro aqui
    }

    @Override
    public Double visitaTriangulo(Triangle triangle) {
        // Multiplicando cada lado por 2
        triangle.setSides(triangle.getSide1() * 2, triangle.getSide2() * 2, triangle.getSide3() * 2 );

        return null;
    }

    @Override
    public Double visitaRetangulo(Retangulo retangulo) {
        // Duplicando a largura e altura
        retangulo.setLargura(retangulo.getLargura() * 2);
        retangulo.setAltura(retangulo.getAltura() * 2);
        return null;
    }

    @Override
    public Double visitaTrapezio(Trapezio trapezio) {
        // Multiplicando cada lado por 2
        trapezio.setBaseMaior(trapezio.getBaseMaior() * 2);
        trapezio.setBaseMenor(trapezio.getBaseMenor() * 2);
        trapezio.setLado1(trapezio.getLado1() * 2);
        trapezio.setLado2(trapezio.getLado2() * 2);
        return null;
    }
}
