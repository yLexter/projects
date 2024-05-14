package interfaces;

import entities.Circulo;
import entities.Retangulo;
import entities.Trapezio;
import entities.Triangle;

public interface IVisitor {
    Double visitaCirculo(Circulo circulo);
    Double visitaTriangulo(Triangle triangle);
    Double visitaRetangulo(Retangulo retangulo);
    Double visitaTrapezio(Trapezio trapezio);
}
