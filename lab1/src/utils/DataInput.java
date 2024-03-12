package utils;

import erros.*;

import java.time.DateTimeException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import interfaces.general.IObjectFactory;
import static utils.Constants.*;



public class DataInput {

    public record ChoiseOption<T> (String label, T option) {
        public String getLabel() {
            return label;
        }

        public T getOption () {
            return option;
        }

    }

    public static <T> void showOptions(List<ChoiseOption<T>> options) {
        int index = startOptionsIndex;

        for(ChoiseOption<T> option : options)
            System.out.printf("%d. %s\n", index++, option.getLabel());
    }

    public static void checkUserLeftMenu(String string) {
        if (string.equals(exitInputString))
            throw new LeftMenuException();
    }

    public static <T> T getElementFromListByUser(List<T> list, Function<T,String> getLabelOption, String label) {

        if (list.size() == 0)
            throw new LeftMenuException("Lista vazia");

        Scanner scanner = Global.getScanner();
        List<ChoiseOption<T>> listOptions = list
                .stream()
                .map(option -> new ChoiseOption<>(getLabelOption.apply(option), option))
                .toList();

        T optionSelected = null;
        int intOption;

        do {
            try {
                System.out.println(label);
                showOptions(listOptions);
                System.out.println("Digite a opção desejada: ");
                String stringOption = scanner.nextLine();

                checkUserLeftMenu(stringOption);

                intOption = Integer.parseInt(stringOption);

                if (intOption < startOptionsIndex || intOption >= listOptions.size() + startOptionsIndex) {
                    Decoration.showMessageAndClearScreen("Opção inválida");
                } else {
                    optionSelected = listOptions.get(intOption - startOptionsIndex).getOption();
                }

            } catch(NumberFormatException err) {
                Decoration.showMessageAndClearScreen("orneça um número inteiro válido");
            }

        } while (optionSelected == null);

        return optionSelected;


    }

    public static <T> List<T> getElementsFromListByUser(List<T> list, Function<T,String> getLabelOption, String label) {

        if (list.size() == 0)
            throw new LeftMenuException("Lista vazia");

        List<ChoiseOption<T>> listOptions;
        List<T> optionsSelected = new ArrayList<>();
        Scanner scanner = Global.getScanner();
        int intOption;
        T optionSelected;

        do {
            try {

                if (optionsSelected.size() == list.size())
                    return optionsSelected;

                ArrayList<T> listWithoutDuplicates = Utils.getIntersectionBetweenLists(list, optionsSelected);
                listOptions = listWithoutDuplicates
                        .stream()
                        .map(option -> new ChoiseOption<>(getLabelOption.apply(option), option))
                        .toList();

                showOptions(listOptions);
                System.out.println(label + " ou digite %s para parar de escolher".formatted(exitInputString));
                System.out.println("Digite a opção desejada: ");

                String stringOption = scanner.nextLine();

                if (stringOption.equals(exitInputString))
                    return optionsSelected;

                intOption = Integer.parseInt(stringOption);

                if (intOption < startOptionsIndex || intOption >= listOptions.size() + startOptionsIndex) {
                    Decoration.showMessageAndClearScreen("Opção inválida");
                    continue;
                }

                optionSelected = listOptions.get(intOption - startOptionsIndex).getOption();

                optionsSelected.add(optionSelected);

                Decoration.clearScreen();

            } catch(NumberFormatException err) {
                Decoration.showMessageAndClearScreen("Forneça um número inteiro válido.");
            }

        } while (true);

    }

}
