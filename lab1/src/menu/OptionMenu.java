package menu;
import interfaces.menu.IMenuOption;


public record OptionMenu(String label, Runnable function) implements IMenuOption {

    

    @Override
    public void run() {
        function.run();
    }

}
