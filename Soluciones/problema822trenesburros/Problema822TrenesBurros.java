import java.util.Scanner;

public class Problema822TrenesBurros {
    // Atributo estático, para usarlo desde cualquier método.
    // Debe estar descomentado para subir la solución a aceptaelreto.com
    private static Scanner sc = new Scanner(System.in);

    // Versión para probar casos de prueba del enunciado.
    // Solo para pruebas. No subir a aceptaelreto.com sin comentar esta línea.
    // private static Scanner sc = new Scanner("3\n50 100\n100 200\n4\n50 100 50\n40 110 40\n0\n");

    public static void main(String[] args) {
        // Leer el número de estaciones, hasta que se lea "0"
        int numEstaciones;
        while ((numEstaciones = sc.nextInt()) != 0) {
            System.out.println(procesarCaso(numEstaciones));
        }
    }

    private static int procesarCaso(int numEstaciones) {
        // Cálculo de número de tramos. Siempre uno menos que estaciones.
        int numTramos = numEstaciones - 1;

        // Arrays para almacenar los tramos (duración del viaje en el tramo)
        // Uno para el tiempo en tren y otro para tiempo en burro.
        int[] tramosTren = new int[numTramos];
        int[] tramosBurro = new int[numTramos];

        // Leer tramos en tren
        for (int i = 0; i < numTramos; i++) {
            tramosTren[i] = sc.nextInt();
        }

        // Leer tramos en burro
        for (int i = 0; i < numTramos; i++) {
            tramosBurro[i] = sc.nextInt();
        }

        // Calcular los casos favorables, en los que el trayecto en burro es más rápido
        return cuentaMejoresBurro(numTramos, tramosTren, tramosBurro);
    }

    /**
     * Calcula el número total de trayectos, de cualquier longitud (máximo numTramos, mínimo 1), en
     * los que es más rápido ir en burro que ir en tren
     *
     * @param numTramos   número de tramos de la vía
     * @param tramosTren  tiempo que se tarda en recorrer cada tramo en tren
     * @param tramosBurro tiempo que se tarda en recorrer cada tramo en burro
     * @return cuantos trayectos de cualquier longitud se hacen más rápido en burro que en tren.
     */
    private static int cuentaMejoresBurro(int numTramos, int[] tramosTren, int[] tramosBurro) {
        int cuentaMejoresBurro = 0;

        // Doble bucle - Complejidad O(n²)
        // Como el juez de aceptaelreto.com lo acepta, no se intenta optimizar a O(n·log(n)). 
        // Si se produjera TLE, quizá habría que intentarlo, pero, en general, es mejor no pensar 
        // en optimizar algo antes de que se produzca el problema. En algunos casos, en las 
        // competiciones, se marcan los problemas con un reloj. Si se encuentra un problema con un 
        // reloj, hay que sospechar que la solución menos ótima (como esta cuadrática) no será válida. 
        for(int inicio = 0; inicio < numTramos; inicio++){
            long sumaTrenes = 0;
            long sumaBurros = 0;
            // Para cada punto de partida se prueban todos los posibles trayectos hasta el final.
            for (int fin = inicio; fin < numTramos; fin++){
                // Cada vez que se "avanza", se suma el tiempo del tramo al total del trayecto, tanto
                // si es en tren como si es en burro
                sumaTrenes+= tramosTren[fin];
                sumaBurros+= tramosBurro[fin];
                // Si el burro es más rápido, se contabiliza el trayecto.
                if (sumaBurros < sumaTrenes){
                    cuentaMejoresBurro++;
                }
            }
        }
        return cuentaMejoresBurro;
    }
}
