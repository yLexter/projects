package sanduiche;

import produto.*;
import produtosConcretos.*;

public class Sanduiche {


    protected Pao criarPao() {
        return new PaoIntegral();
    }

    protected Queijo criarQueijo() {
        return new QueijoPrato();
    }

    protected Presunto criarPresunto() {
        return new PresuntoFrango();
    }

    protected Ovo criarOvo() {
        return new OvoCapoeira();
    }

    protected Tomate criarTomate() {
        return new TomateComum();
    }


    public String criarSanduiche() {
        return "Sanduíche com " + criarPao().getTipo() + ", " + criarQueijo().getTipo() + ", " + criarPresunto().getTipo() + ", " + criarOvo().getTipo() + " e " + criarTomate().getTipo();
    }
}
