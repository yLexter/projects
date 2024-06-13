import sanduiche.Sanduiche;
import sanduicheFactory.SanduicheDePresuntoDePapaiLulinha;
import sanduicheFactory.SanduicheDePresuntoDoChavesFactory;
import sanduicheFactory.SanduicheFactory;
import sanduicheFactory.SanduicheicheDeFrango;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<SanduicheFactory> factorys = List.of(
                new SanduicheDePresuntoDePapaiLulinha(),
                new SanduicheDePresuntoDoChavesFactory(),
                new SanduicheicheDeFrango()
        );

        for (SanduicheFactory factory : factorys) {
            Sanduiche sanduiche = factory.criarSanduiche();
            System.out.println(sanduiche);
            System.out.println();
        }

    }
}
