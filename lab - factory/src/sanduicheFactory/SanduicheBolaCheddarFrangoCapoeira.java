package sanduicheFactory;

import produto.Pao;
import produto.Queijo;
import produtosConcretos.PaoBola;
import produtosConcretos.QueijoCheddar;
import sanduiche.Sanduiche;

public class SanduicheBolaCheddarFrangoCapoeira extends Sanduiche {
    @Override
    protected Pao criarPao() {
        return new PaoBola();
    }

    @Override
    protected Queijo criarQueijo() {
        return new QueijoCheddar();
    }
}
