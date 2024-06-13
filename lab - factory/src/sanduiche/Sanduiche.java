package sanduiche;

import produto.*;

public class Sanduiche {
    protected Pao pao;
    protected Queijo queijo;
    protected Presunto presunto;
    protected Ovo ovo;
    protected Tomate tomate;

    public Sanduiche(Pao pao, Queijo queijo, Presunto presunto, Ovo ovo, Tomate tomate) {
        this.pao = pao;
        this.queijo = queijo;
        this.presunto = presunto;
        this.ovo = ovo;
        this.tomate = tomate;
    }

    public Pao getPao() {
        return pao;
    }

    public Queijo getQueijo() {
        return queijo;
    }

    public Presunto getPresunto() {
        return presunto;
    }

    public Ovo getOvo() {
        return ovo;
    }

    public Tomate getTomate() {
        return tomate;
    }

    @Override
    public String toString() {
        return "Sanduíche com " + pao.getTipo() + ", " + queijo.getTipo() + ", " + presunto.getTipo() + ", " + ovo.getTipo() + " e " + tomate.getTipo();
    }

}
