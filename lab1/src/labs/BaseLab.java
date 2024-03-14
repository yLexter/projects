package labs;

import interfaces.menu.IResponseLab;

import java.util.List;

public abstract class BaseLab {

     public abstract List<IResponseLab> getOptions();

    public void run() {
        List<IResponseLab> options = getOptions();

        for (IResponseLab option : options) {
            System.out.println("-".repeat(50));
            System.out.printf("Pergunta: %s\n\n", option.label());
            option.run();
            System.out.println();
        }

        System.out.println("-".repeat(50));
    }

}
