import java.util.Scanner;

public class Problema764ColgadasColgantes {

    // Problema de tipo fácil. Simplemente leer de entrada linea por línea y
    // comparar con una muestra.

    // Atributo estático, para usarlo desde cualquier método.
    // Debe estar descomentado para subir la solución a aceptaelreto.com
    private static Scanner scanner = new Scanner(System.in);

    // Versión para probar casos de prueba del enunciado.
    // Sólo para pruebas. No subir a aceptaelreto.com sin comentar esta línea.
    // private static Scanner scanner = new
    // Scanner("3\ncolgadas\nCOLGANTES\nColgadaS\n");

    public static void main(String[] args) {

        // Leer número de casos
        int numCasos = Integer.parseInt(scanner.nextLine());

        // Procesar los casos
        while (numCasos-- > 0) {
            // Leer palabra
            String palabra = scanner.nextLine();
            // Si es "colgadas", ignorando mayúsculas, mostrar "Bien". Mostrar "Mal" en
            // cualquier otro caso.
            System.out.println(palabra.equalsIgnoreCase("colgadas") ? "Bien" : "Mal");
        }

    }

}
