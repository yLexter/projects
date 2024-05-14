import entities.Circulo;
import entities.Retangulo;
import entities.Trapezio;
import entities.Triangle;
import interfaces.IVisitor;
import visitors.VisitorCalculaArea;
import visitors.VisitorCalculaPerimetro;
import visitors.VisitorDesenhar;
import visitors.VisitorMaximizarFigura;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        VisitorCalculaArea visitorCalculaArea = new VisitorCalculaArea();
        VisitorDesenhar visitorDesenhar = new VisitorDesenhar();
        VisitorCalculaPerimetro visitorCalculaPerimetro = new VisitorCalculaPerimetro();
        VisitorMaximizarFigura visitorMaximizaFigura = new VisitorMaximizarFigura();

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

        var trapezios = List.of(
                new Trapezio(4, 6, 3, 4, 5),
                new Trapezio(3, 5, 2, 3, 4)
        );



        // Desenha e mostra a área dos trapézios
        System.out.println("TRAPÉZIOS:");
        trapezios.forEach(trapezio -> {
            System.out.println("-".repeat(50));
            trapezio.aceitarVisitor(visitorDesenhar);


            double areaTrapezio = trapezio.aceitarVisitor(visitorCalculaArea);
            double perimetroTrapezio = trapezio.aceitarVisitor(visitorCalculaPerimetro);

            System.out.println("-".repeat(50));
            System.out.println(trapezio);
            System.out.printf("A área do trapézio é %.2f\n", areaTrapezio);
            System.out.printf("A perimetro é %.2f\n", perimetroTrapezio);
            System.out.println();

            // Maximiza a figura
            System.out.println("Maximizando figura...");
            trapezio.aceitarVisitor(visitorMaximizaFigura);
            trapezio.aceitarVisitor(visitorDesenhar);
            double areaTrapezioMaximizado = trapezio.aceitarVisitor(visitorCalculaArea);
            double perimetroTrapezioMaximizado = trapezio.aceitarVisitor(visitorCalculaPerimetro);
            System.out.printf("Área após maximização: %.2f\n", areaTrapezioMaximizado);
            System.out.printf("Perímetro após maximização: %.2f\n", perimetroTrapezioMaximizado);
        });
        System.out.println();

        // Desenha e mostra a area dos retangulos
        retangulos.forEach(retangulo -> {
            System.out.println("-".repeat(50));

            retangulo.aceitarVisitor(visitorDesenhar);

            double areaRetangulo = retangulo.aceitarVisitor(visitorCalculaArea);

            System.out.println("-".repeat(50));
            System.out.println(retangulo);
            System.out.printf("A área do retangulo é %.2f\n", areaRetangulo);
            double perimetroRetangulo = retangulo.aceitarVisitor(visitorCalculaPerimetro) ;
            System.out.printf("A perimetro é %.2f\n", perimetroRetangulo);
            System.out.println();

            // Maximiza a figura
            System.out.println("Maximizando figura...");
            retangulo.aceitarVisitor(visitorMaximizaFigura);
            retangulo.aceitarVisitor(visitorDesenhar);
            double areaTrapezioMaximizado = retangulo.aceitarVisitor(visitorCalculaArea);
            double perimetroTrapezioMaximizado = retangulo.aceitarVisitor(visitorCalculaPerimetro);
            System.out.printf("Área após maximização: %.2f\n", areaTrapezioMaximizado);
            System.out.printf("Perímetro após maximização: %.2f\n", perimetroTrapezioMaximizado);

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
            double perimetroTriangulo = triangle.aceitarVisitor(visitorCalculaPerimetro) ;
            System.out.printf("A perimetro é %.2f\n", perimetroTriangulo);
            System.out.println("-".repeat(50));
            System.out.println();

            // Maximiza a figura
            System.out.println("Maximizando figura...");
            triangle.aceitarVisitor(visitorMaximizaFigura);
            triangle.aceitarVisitor(visitorDesenhar);
            double areaTrapezioMaximizado = triangle.aceitarVisitor(visitorCalculaArea);
            double perimetroTrapezioMaximizado = triangle.aceitarVisitor(visitorCalculaPerimetro);
            System.out.printf("Área após maximização: %.2f\n", areaTrapezioMaximizado);
            System.out.printf("Perímetro após maximização: %.2f\n", perimetroTrapezioMaximizado);


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

            double perimetroCirculo = circulo.aceitarVisitor(visitorCalculaPerimetro) ;
            System.out.printf("A perimetro é %.2f\n", perimetroCirculo);
            System.out.println();

            // Maximiza a figura
            System.out.println("Maximizando figura...");
            circulo.aceitarVisitor(visitorMaximizaFigura);
            circulo.aceitarVisitor(visitorDesenhar);
            double areaTrapezioMaximizado = circulo.aceitarVisitor(visitorCalculaArea);
            double perimetroTrapezioMaximizado = circulo.aceitarVisitor(visitorCalculaPerimetro);
            System.out.printf("Área após maximização: %.2f\n", areaTrapezioMaximizado);
            System.out.printf("Perímetro após maximização: %.2f\n", perimetroTrapezioMaximizado);


            System.out.println();
        });

    }
}