package utils;

import java.util.ArrayList;
import java.util.List;

public class Decoration {

  
    public static void clearScreen() {
        System.out.println("\n".repeat(50));
    }

    

    public static String generateWelcomeHeader(String name) {
        int nameLength = name.length();
        int horizontalPadding = 2; 
        int totalWidth = nameLength + horizontalPadding * 2;

        return "┌" + "─".repeat(totalWidth) + "┐" + "\n" +
                "│" + " ".repeat(horizontalPadding) + "Bem Vindo" + " ".repeat(horizontalPadding) + "" + "\n" +
                "│" + " ".repeat(horizontalPadding) + name + " ".repeat(horizontalPadding) + "│" + "\n" +
                "└" + "─".repeat(totalWidth) + "┘" + "\n";
    }
    public static void showMessageAndClearScreen(String errorMessage) {
        int messageLength = errorMessage.length();
        int borderLength = messageLength + 4;

        String horizontalBorder = "+" + "-".repeat(borderLength - 2) + "+";
        String verticalBorder = "|";

        System.out.println(horizontalBorder);
        System.out.println(verticalBorder + " " + " ".repeat(messageLength) + " " + verticalBorder);
        System.out.println(verticalBorder + " " + errorMessage + " " + verticalBorder);
        System.out.println(verticalBorder + " " + " ".repeat(messageLength) + " " + verticalBorder);
        System.out.println(horizontalBorder);

        sleep(2.5D);

        clearScreen();
    }

   
    public static void sleep(Number seconds) {
        try {
           Thread.sleep(seconds.longValue() * 1000L);
        } catch (InterruptedException ignored) {}
    }

}
