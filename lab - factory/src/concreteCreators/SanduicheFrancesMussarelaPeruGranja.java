package concreteCreators;

import creator.Sanduiche;
import produtosConcretos.*;

public class SanduicheFrancesMussarelaPeruGranja extends Sanduiche {
    @Override
    public void criarSanduiche() {
        this.pao = new PaoFrances();
        this.queijo = new QueijoMussarela();
        this.presunto = new PresuntoPeru();
        this.ovo = new OvoGranja();
        this.tomate = new TomateComum();
    }
}
