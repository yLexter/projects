package menu;

import interfaces.menu.*;
import java.util.List;

public class MenuSystem implements IMenu {

    /**
     * Retorna as opções do menu.
     *
     * @return as opções do menu
     */
    @Override
    public List<ISubMenuOption> getOptions() {

        return List.of(
          new OptionMenu("Ver informações de um professor", this::showCollegeClassOfTeacher),
          new OptionMenu("Ver dados de uma disciplina", this::showCollegeClassOfTeacher),
          new OptionMenu("Ver dados de uma aluno", this::showCollegeClassOfTeacher)
        );

    }

    public void showCollegeClassOfTeacher() {
        System.out.println("Teste");
    }


    @Override
    public String getHeader() {
        List<String> lines = List.of(
                "|------------------------|",
                "|       Bem Vindo        |",
                "|     Ao AcademyPlus     |",
                "|                        |",
                "|------------------------|"
        );

        return String.join("\n", lines);
    }

    @Override
    public void run() {
        new MenuExecutor(this).run();
    }



}