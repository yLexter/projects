package creator;

import produto.*;

public abstract class Sanduiche {
    protected Pao pao;
    protected Queijo queijo;
    protected Presunto presunto;
    protected Ovo ovo;
    protected Tomate tomate;

    public abstract void criarSanduiche();

    @Override
    public String toString() {
        return "Sanduíche com " + pao.getTipo() + ", " + queijo.getTipo() + ", " + presunto.getTipo() + ", " + ovo.getTipo() + " e " + tomate.getTipo();
    }
}
