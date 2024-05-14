public class Main {
    public static void main(String[] args) {
        desenharTrapezio(6, 5, 10); // Parâmetros: altura, base maior, base menor
    }

    public static void desenharTrapezio(int altura, int baseMaior, int baseMenor) {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < baseMenor + i * (baseMaior - baseMenor) / (altura - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
