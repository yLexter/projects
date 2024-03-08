package utils;

import java.util.Scanner;

/**
 * A classe Global contém métodos estáticos para acessar objetos globais do sistema.
 */
public class Global {
    private static Scanner scanner;

  /**
     * Obtém uma instância do Scanner para entrada de dados do usuário.
     * Se o Scanner já estiver inicializado, retorna a instância existente;
     * caso contrário, cria uma nova instância e a retorna.
     * @return Instância do Scanner.
     */
    public static Scanner getScanner() {
        if (scanner != null)
            return scanner;
        return scanner = new Scanner(System.in);
    }

}
