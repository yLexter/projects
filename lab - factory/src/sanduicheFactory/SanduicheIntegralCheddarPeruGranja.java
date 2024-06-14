package sanduicheFactory;

import produto.Ovo;
import produto.Pao;
import produto.Presunto;
import produto.Queijo;
import produtosConcretos.OvoGranja;
import produtosConcretos.PaoIntegral;
import produtosConcretos.PresuntoPeru;
import produtosConcretos.QueijoCheddar;
import sanduiche.Sanduiche;

public class SanduicheIntegralCheddarPeruGranja extends Sanduiche {
    @Override
    protected Pao criarPao() {
        return new PaoIntegral();
    }

    @Override
    protected Queijo criarQueijo() {
        return new QueijoCheddar();
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