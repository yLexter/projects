package concreteCreators;

import creator.Sanduiche;
import produtosConcretos.*;

public class SanduicheIntegralPratoFrangoCapoeira extends Sanduiche {
    @Override
    public void criarSanduiche() {
        this.pao = new PaoIntegral();
        this.queijo = new QueijoPrato();
        this.presunto = new PresuntoFrango();
        this.ovo = new OvoCapoeira();
        this.tomate = new TomateComum();
    }
}

