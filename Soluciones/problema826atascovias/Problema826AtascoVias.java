import java.util.Scanner;

// Observaciones sobre interpretación de este problema.
// Cuando se analiza la entrada de un caso de prueba como este: 5 2 5 4 4 6 7
// Se pueden hacer dos interpretaciones:
// - Que los trenes de la misma velocidad salen separados y no forman grupo. Quedarían:
//      5 grupos: 52 54 4 6 7
// - Que los trenes de la misma velocidad sí forman grupo. Quedarían:
//      4 grupos: 52 544 6 7
// Aunque intuitivamente se puede pensar que la primera opción es la más correcta, al pensar
// que dos trenes no pueden salir juntos, el juez de acepta el reto está considerando correcta
// la segunda opción. Aquí habría que entrar a debatir si el enunciado, que no menciona nada
// sobre si hay separación inicial entre trenes, es lo suficientemente claro. Pero de momento,
// el comportamiento (a diciembre de 2025) es el que es.
public class Problema826AtascoVias {
    // Atributo estático, para usarlo desde cualquier método.
    // Debe estar descomentado para subir la solución a aceptaelreto.com
    private static Scanner sc = new Scanner(System.in);

    // Versión para probar casos de prueba del enunciado, y un caso "límite" con trenes de
    // la misma velocidad. Solo para pruebas. No subir a aceptaelreto.com sin comentar esta línea.
    // private static Scanner sc = new Scanner("3\n3 2 1\n3\n2 1 3\n7\n5 2 5 4 4 6 7\n");

    public static void main(String[] args) {
        // Leer número de casos, y repetir tantas veces como casos haya
        while (sc.hasNext()) {
            // Procesar el caso
            procesarCaso();
        }
    }

    private static void procesarCaso() {
        // Leer número de trenes
        int numTrenes = sc.nextInt();

        // Leer velocidades y almacenarlas en un array
        long[] velocidades = new long[numTrenes];
        for (int i = 0; i < velocidades.length; i++) {
            velocidades[i] = sc.nextLong();
        }

        // Valor inicial muy grande para que el primer tren forme un grupo
        long velocidadGrupoActual = Long.MAX_VALUE;

        // Se recorre el array desde el final (primer tren que salió) hasta el
        // principio (último tren que salió). Cada vez que se encuentra un tren más lento
        // que la velocidad del grupo actual, forma su grupo. Si la velocidad es igual, no
        // forma grupo, por lo que se ha comentado al principio del problema, que acepta
        // el reto no considera que haya separación entre trenes de la misma velocidad.
        int numGrupos = 0;
        for (int i = velocidades.length - 1; i >= 0; i--) {
            if (velocidades[i] < velocidadGrupoActual) {
                numGrupos++;
                velocidadGrupoActual = velocidades[i];
            }
        }

        // Mostrar salida
        System.out.println(numGrupos);
    }
}
