import entities.Circulo;
import entities.Retangulo;
import entities.Triangle;
import interfaces.IVisitor;
import visitors.VisitorCalculaArea;
import visitors.VisitorDesenhar;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        VisitorCalculaArea visitorCalculaArea = new VisitorCalculaArea();
        VisitorDesenhar visitorDesenhar = new VisitorDesenhar();

        var circulos = List.of(
            new Circulo(5),
            new Circulo(8)
        );

        var triangulos = List.of(
            new Triangle(5,5,5),
            new Triangle(5,5,9)
        );

        var retangulos = List.of(
            new Retangulo(5,6),
            new Retangulo(4,5)
        );

        // Desenha e mostra a area dos retangulos
        retangulos.forEach(retangulo -> {
            System.out.println("-".repeat(50));

            retangulo.aceitarVisitor(visitorDesenhar);

            double areaCirculo = retangulo.aceitarVisitor(visitorCalculaArea);

            System.out.println("-".repeat(50));
            System.out.println(retangulo);
            System.out.printf("A área do retangulo é %.2f\n", areaCirculo);

            System.out.println();
        });

        System.out.println();

        // Desenha e mostra a area dos triangulos
        triangulos.forEach(triangle -> {
            System.out.println("-".repeat(50));

            triangle.aceitarVisitor(visitorDesenhar);

            System.out.println();

            double areaTriangulo = triangle.aceitarVisitor(visitorCalculaArea);

            System.out.println("-".repeat(50));
            System.out.println(triangle);
            System.out.printf("A área do triangulo é %.2f\n", areaTriangulo);
            System.out.println("-".repeat(50));

            System.out.println();
        });

        System.out.println();

        // Desenha e mostra a area dos circulos
        circulos.forEach(circulo -> {
            System.out.println("-".repeat(50));
            circulo.aceitarVisitor(visitorDesenhar);

            double areaCirculo = circulo.aceitarVisitor(visitorCalculaArea);

            System.out.println("-".repeat(50));
            System.out.println(circulo);
            System.out.printf("A área do círculo é %.2f\n", areaCirculo);

            System.out.println();
        });

    }
}