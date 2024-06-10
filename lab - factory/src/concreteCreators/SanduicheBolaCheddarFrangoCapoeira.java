package concreteCreators;


import creator.Sanduiche;
import produtosConcretos.*;

public class SanduicheBolaCheddarFrangoCapoeira extends Sanduiche {
    @Override
    public void criarSanduiche() {
        this.pao = new PaoBola();
        this.queijo = new QueijoCheddar();
        this.presunto = new PresuntoFrango();
        this.ovo = new OvoCapoeira();
        this.tomate = new TomateComum();
    }
}
