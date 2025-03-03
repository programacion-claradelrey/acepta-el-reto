import java.util.Scanner;

public class Problema767PlanificandoAcueducto {

    private static Scanner scanner = new Scanner(System.in);

    // private static Scanner scanner = new Scanner("3\n10 9 8\n4\n100 90 80
    // 90\n4\n100 90 110 100\n4\n82 70 60 81\n0");

    public static void main(String[] args) {

        int numMedidas;
        while ((numMedidas = scanner.nextInt()) > 0) {
            long[] medidasOriginales = new long[numMedidas];
            long[] candidatos = new long[numMedidas];
            long[] diferencias = new long[numMedidas];
            for (int i = 0; i < numMedidas; i++) {
                medidasOriginales[i] = scanner.nextLong();
            }
            long candidato = medidasOriginales[0];
            long minimaDiferencia = Integer.MAX_VALUE;
            for (int i = 0; i < numMedidas; i++) {
                candidatos[i] = candidato;
                diferencias[i] = candidatos[i] - medidasOriginales[i];
                if (diferencias[i] < minimaDiferencia) {
                    minimaDiferencia = diferencias[i];
                }
                candidato--;
            }
            for (int i = 0; i < numMedidas; i++) {
                diferencias[i] -= minimaDiferencia;
            }

            // printArray(medidasOriginales);
            // printArray(candidatos);
            printArray(diferencias);
        }
    }

    private static void printArray(long[] diferencias) {
        for (int i = 0; i < diferencias.length; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(diferencias[i]);
        }
        System.out.println();
    }
}