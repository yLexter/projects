package sanduicheFactory;


import sanduiche.Sanduiche;
import produtosConcretos.*;

public class SanduicheDePresuntoDePapaiLulinha extends SanduicheFactory {
    @Override
    public Sanduiche criarSanduiche() {
        return new Sanduiche(
                new PaoFrances(),
                new QueijoCheddar(),
                new PresuntoFrango(),
                new OvoCapoeira(),
                new TomateComum()
        );
    }

}
