import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problema768CampanasManquita {
    private static Scanner scanner = new Scanner(System.in);

    // private static Scanner scanner = new
    // Scanner("AAB\nBAAA\nMALAGA\nOLAALAAA\n");

    public static void main(String[] args) {

        while (scanner.hasNext()) {
            String melodia = scanner.nextLine();

            int numNotas = melodia.length();

            Map<Character, Integer> frecuencias = new HashMap<>();
            for (Character nota : melodia.toCharArray()) {
                if (frecuencias.containsKey(nota)) {
                    frecuencias.put(nota, frecuencias.get(nota) + 1);
                } else {
                    frecuencias.put(nota, 1);
                }
            }

            int maximaFrecuencia = 0;
            for (Map.Entry<Character, Integer> entry : frecuencias.entrySet()) {
                if (entry.getValue() > maximaFrecuencia) {
                    maximaFrecuencia = entry.getValue();
                }
            }

            int mitadNotas = (int) Math.ceil((double) numNotas / 2);

            System.out.println((maximaFrecuencia > mitadNotas) ? "NO" : "SI");
        }
    }
}
