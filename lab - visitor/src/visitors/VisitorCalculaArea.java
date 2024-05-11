package visitors;

import entities.Circulo;
import entities.Retangulo;
import entities.Triangle;
import interfaces.IVisitor;

public class VisitorCalculaArea implements IVisitor {

    @Override
    public Double visitaCirculo(Circulo circulo) {
        return Math.pow(circulo.getRaio(), 2) * Math.PI;
    }

    @Override
    public Double visitaTriangulo(Triangle triangle) {
        var side1 = triangle.getSide1();
        var side2 = triangle.getSide2();
        var side3 = triangle.getSide3();

        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public Double visitaRetangulo(Retangulo retangulo) {
        return retangulo.getLargura() * retangulo.getAltura();
    }

}
