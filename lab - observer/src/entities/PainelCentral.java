package entities;

import interfaces.IObserver;

import java.util.List;

public class PainelCentral implements IObserver {
    @Override
    public void update(List<AcentoOnibus> acentos) {
        System.out.println("-".repeat(50));
        System.out.println("---- Painel Central Atualizado -------");
        System.out.println();

        for (AcentoOnibus acento : acentos) {

            String color = switch (acento.getStatus()) {
                case DISPONIVEL -> "Verde";
                case RESERVADO -> "Amarelo";
                case INDISPONIVEL -> "Vermelho";
            };

            System.out.printf("[%s] Acento (%d) \n", color, acento.getNumero());
        }
        System.out.println("-".repeat(50));
    }

}