package entidades.funcoes;

import interfaces.IFuncaoFilme;

public class Diretor implements IFuncaoFilme {

    @Override
    public void exercer() {
        System.out.println("Dirigindo filme...");
    }

    @Override
    public String toString() {
        return "Diretor";
    }
    
}
