package labs;

import interfaces.menu.IResponseLab;

public record ResponseLab(String label, Runnable function) implements IResponseLab {

    @Override
    public void run() {
        function.run();
    }

}
