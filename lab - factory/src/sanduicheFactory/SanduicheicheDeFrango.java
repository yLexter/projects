package sanduicheFactory;

import produtosConcretos.*;
import sanduiche.Sanduiche;

public class SanduicheicheDeFrango extends SanduicheFactory{

    @Override
    public Sanduiche criarSanduiche() {
        return new Sanduiche(
            new PaoBola(),
            new QueijoPrato(),
            new PresuntoFrango(),
            new OvoGranja(),
            new TomateComum()
        );
    }


}
