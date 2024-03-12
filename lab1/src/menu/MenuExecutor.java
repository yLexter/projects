package menu;

import erros.LeftMenuException;
import interfaces.menu.IMenu;
import interfaces.menu.IMenuOption;
import utils.Decoration;
import utils.Global;
import java.util.*;
import static utils.Constants.startOptionsIndex;

public class MenuExecutor {
    private final IMenu menu;
    private final List<IMenuOption> options;

    public MenuExecutor(IMenu menu) {
        this.menu = menu;
        this.options = menu.getOptions();
    }

  
    void run() {

        Scanner scanner = Global.getScanner();
        int intOption;

        while(true) {

            try {
                System.out.println(menu.getHeader());

                printMenu();
                System.out.println("Digite a opção desejada: ");
                intOption = Integer.parseInt(scanner.nextLine());

                if(intOption == options.size() + startOptionsIndex)
                    break;

                if (intOption < startOptionsIndex || intOption > options.size() + startOptionsIndex) {
                    Decoration.showMessageAndClearScreen("Opção inválida");
                } else {
                    options.get(intOption - startOptionsIndex).run();
                }

             } catch(NumberFormatException err) {
                Decoration.showMessageAndClearScreen("Forneça um número inteiro válido.");
             } catch (LeftMenuException err) {
                if (err.getMessage() != null)
                    Decoration.showMessageAndClearScreen("ERROR: %s\n".formatted(err.getMessage()));
            } catch (RuntimeException err) {
                Decoration.showMessageAndClearScreen("Error: %s".formatted(err.getMessage()));
            }

        }
    }

  
    void printMenu() {

        int index = startOptionsIndex;

        for(IMenuOption option : options)
            System.out.printf("%d. %s\n", index++, option.label());

        System.out.printf("%d. Sair\n", options.size() + startOptionsIndex);
    }


}
