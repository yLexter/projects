import entities.Onibus;
import entities.PainelCentral;
import enums.AcentoStatus;
import observer.ObserverManger;

public class Main {
    public static void main(String[] args) {

        ObserverManger observerManger = new ObserverManger();
        PainelCentral painelCentral = new PainelCentral();
        Onibus onibus = new Onibus(
                "300B",
                10,
                observerManger
        );

        observerManger.addObserver(painelCentral);

        onibus.atualizarStatusAcento(
            5,
            AcentoStatus.INDISPONIVEL
        );

    }
}