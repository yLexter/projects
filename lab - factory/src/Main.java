import concreteCreators.*;
import creator.Sanduiche;

public class Main {
    public static void main(String[] args) {
        Sanduiche sanduiche1 = new SanduicheIntegralPratoFrangoCapoeira();
        sanduiche1.criarSanduiche();
        System.out.println(sanduiche1);

        Sanduiche sanduiche2 = new SanduicheFrancesMussarelaPeruGranja();
        sanduiche2.criarSanduiche();
        System.out.println(sanduiche2);

        Sanduiche sanduiche3 = new SanduicheBolaCheddarFrangoCapoeira();
        sanduiche3.criarSanduiche();
        System.out.println(sanduiche3);
    }
}
