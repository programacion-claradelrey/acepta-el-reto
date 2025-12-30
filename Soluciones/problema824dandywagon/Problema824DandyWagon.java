import java.util.Scanner;

public class Problema824DandyWagon {
    // Atributo estático, para usarlo desde cualquier método.
    // Debe estar descomentado para subir la solución a aceptaelreto.com
    private static Scanner sc = new Scanner(System.in);

    // Versión para probar casos de prueba del enunciado.
    // Solo para pruebas. No subir a aceptaelreto.com sin comentar esta línea.
    // private static Scanner sc = new Scanner("4\n1 2 3 0\n4\n-3 -2 -1 0\n4\n3 3 -4 -4\n7\n1 -1 0 2 -2 3 -3\n0\n");

    public static void main(String[] args) {
        // Leer número de tramos del caso, y repetir hasta que el número de tramos sea cero.
        int numTramos;
        while ((numTramos = sc.nextInt()) != 0) {
            procesarCaso(numTramos);
        }
    }

    private static void procesarCaso(int numTramos) {

        // Variable para ir acumulando la velocidad
        int velocidadActual = 0;

        // Saltar tramos iniciales <= 0. Hasta que no se alcanza un
        // tramo de bajada no pueden comenzar a descansar las bajadas.
        while (numTramos > 0 && velocidadActual <= 0) {
            velocidadActual = sc.nextInt();
            numTramos--;
        }

        // Al salir del bucle anterior puede ser porque se haya llegado al final
        // de la via. Si eso es así, hay que comprobar el caso "límite" en que solo
        // hay un tramo con pendiente, el último.
        if (numTramos == 0) {
            System.out.println(velocidadActual > 0 ? 1 : 0);
            return;
        }

        // Comenzar a buscar series de tramos. En este punto se ha encontrado un tramo en
        // que el tren va cuesta abajo. Por eso la longitud se inicializa a 1
        int maxLongitud = 1;
        int longitudActual = 1;

        // Hay que ir recorriendo todos los tramos
        while (numTramos-- > 0) {
            // Leer cuanto cambia la velocidad
            int incremento = sc.nextInt();

            // Si llega un tramo "neutro", con incremento cero, si ya había velocidad cero,
            // no se considera que se mantenga velocidad. Por así decirlo, el tren se para
            // justo antes de llegar al tramo "neutro".
            if (incremento == 0 && velocidadActual == 0) {
                // En este caso, hay que "romper" la racha de tramos. Es uno de los casos "marginales".
                // Como la velocidad ya es cero, no hay que cambiarla.
                maxLongitud = Math.max(maxLongitud, longitudActual);
                longitudActual = 0;
            } else {
                // Si al incrementar / decrementar la velocidad se sigue por encima de cero,
                // se contabiliza el tramo.
                if (velocidadActual + incremento >= 0) {
                    velocidadActual += incremento;
                    longitudActual++;
                } else {
                    // Se frena a menos de cero, hay que enganchar los caballos.
                    // Se recalcula el máximo y se reinicia la velocidad a cero.
                    maxLongitud = Math.max(maxLongitud, longitudActual);
                    velocidadActual = 0;
                    longitudActual = 0;
                }
            }
        }

        // Al terminar, hay qye hacer una última comprobación, porque puede
        // que con el último tramo se haya conseguido una "racha" más larga.
        maxLongitud = Math.max(maxLongitud, longitudActual);

        // Mostrar resultado.
        System.out.println(maxLongitud);
    }
}
