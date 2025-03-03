import java.util.Scanner;

public class Problema764AnillamientoAlbufera {

    //

    // Atributo estático, para usarlo desde cualquier método.
    // Debe estar descomentado para subir la solución a aceptaelreto.com
    private static Scanner scanner = new Scanner(System.in);

    // Versión para probar casos de prueba del enunciado.
    // Sólo para pruebas. No subir a aceptaelreto.com sin comentar esta línea.
    // private static Scanner scanner = new Scanner("2\n4 0\n3 3\n3\n10 0\n20 3\n4
    // 0\n0\n");

    public static void main(String[] args) {

        // Leer número de campañas
        int numCampanias = scanner.nextInt();

        // Repetir mientras el número de campañas sea mayor que cero.
        while (numCampanias > 0) {

            // Procesamos el caso
            procesarCaso(numCampanias);

            // Leer el siguiente número de campañas
            numCampanias = scanner.nextInt();
        }

    }

    private static void procesarCaso(int numCampanias) {
        // Para acumular aves anilladas
        int totalAnilladas = 0;

        // Repetir para cada campaña
        while (numCampanias-- > 0) {
            // Leer aves capturadas en campaña
            int numCapturadas = scanner.nextInt();
            // Leer aves previamente anilladas
            int numAnilladas = scanner.nextInt();

            // Acumular la diferencia entre unas y otras
            totalAnilladas += (numCapturadas - numAnilladas);
        }

        // Mostrar resultado del caso
        System.out.println(totalAnilladas);
    }

}
