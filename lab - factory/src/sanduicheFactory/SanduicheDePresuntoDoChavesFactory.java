package sanduicheFactory;

import sanduiche.Sanduiche;
import produtosConcretos.*;

public class SanduicheDePresuntoDoChavesFactory extends SanduicheFactory {
    @Override
    public Sanduiche criarSanduiche() {
        return new Sanduiche(
                new PaoFrances(),
                new QueijoMussarela(),
                new PresuntoPeru(),
                new OvoGranja(),
                new TomateComum()
        );
    }
}
