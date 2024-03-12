package interfaces.menu;

import java.util.List;


public interface IMenu {
    
    void run();

    
    List<IMenuOption> getOptions();

    
    String getHeader();
}

