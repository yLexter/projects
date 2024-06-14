package sanduicheFactory;

import produto.Ovo;
import produto.Pao;
import produto.Presunto;
import produto.Queijo;
import produtosConcretos.OvoGranja;
import produtosConcretos.PaoFrances;
import produtosConcretos.PresuntoPeru;
import produtosConcretos.QueijoMussarela;
import sanduiche.Sanduiche;

public class SanduicheFrancesMussarelaPeruGranja extends Sanduiche {
    @Override
    protected Pao criarPao() {
        return new PaoFrances();
    }

    @Override
    protected Queijo criarQueijo() {
        return new QueijoMussarela();
    }

    @Override
    protected Presunto criarPresunto() {
        return new PresuntoPeru();
    }

    @Override
    protected Ovo criarOvo() {
        return new OvoGranja();
    }
}

