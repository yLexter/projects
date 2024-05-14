package visitors;

import entities.Circulo;
import entities.Retangulo;
import entities.Triangle;
import entities.Trapezio;
import interfaces.IVisitor;

public class VisitorDesenhar implements IVisitor {
    @Override
    public Double visitaCirculo(Circulo circulo) {

        if (circulo == null) {
            throw new IllegalArgumentException("Circulo não pode ser nulo");
        }

        System.out.println("Desenhando: ");
        System.out.println(circulo);
        System.out.println();

        int raio = 4;

        for (int y = -raio; y <= raio; y++) {
            for (int x = -raio; x <= raio; x++) {
                if (x * x + y * y <= raio * raio) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        return null;
    }

    @Override
    public Double visitaTriangulo(Triangle triangle) {

        System.out.println("Desenhando: ");
        System.out.println(triangle);
        System.out.println();

        int altura = 4;

        for (int i = 1; i <= altura; i++) {
            for (int j = 1; j <= altura - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        return null;
    }

    @Override
    public Double visitaRetangulo(Retangulo retangulo) {
        int ladoB = (int) retangulo.getAltura();
        int ladoA = (int) retangulo.getLargura();

        System.out.println("Desenhando: ");
        System.out.println(retangulo);
        System.out.println();

        for (int i = 0; i < ladoB; i++) {
            for (int j = 0; j < ladoA; j++) {
                if (i == 0 || i == ladoB - 1 || j == 0 || j == ladoA - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        return null;
    }

    @Override
    public Double visitaTrapezio(Trapezio trapezio) {
        System.out.println("Desenhando Trapézio:");
        int altura = (int) trapezio.getAltura();
        int baseMaior = (int) trapezio.getBaseMaior();
        int baseMenor = (int) trapezio.getBaseMenor();

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < baseMenor + i * (baseMaior - baseMenor) / (altura - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        return null;
    }





}
