import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Problema típico de búsqueda de camino más corto en grafos no ponderados. Los grafos son una estructura
// de datos que permiten representar situaciones del mundo real como mapas, redes de carreteras, estados
// de sistemas, flujos de decisiones, etc.
// Este problema de camino mínimo se soluciona muy fácilmente con el algoritmo BFS (Breadth First Search).
// En español este algoritmo se puede encontrar como "búsqueda en anchura" o "búsqueda en amplitud",
// o "recorrido en anchura" (cuando no simplemente se búsca, sino que se recorre completamente el grafo),
// o "búsqueda por niveles".
// Este algoritmo, muy resumido, consiste en usar una cola para procesar los nodos, de la siguiente forma:
// - Se mete el nodo (casilla de la rejilla) inicial en la cola.
// - Se saca un nodo, se procesa (mirar si se ha llegado al final) y se añaden a la cola sus vecinos no visitados.
// - Se repite hasta que la cola esté vacía.
// Este algoritmo garantiza el camino mínimo en grafos no ponderados, donde el coste de saltar de un nodo
// a otro siempre es el mismo.
public class Problema820DuquesCondesVizcondes {
    // Atributo estático, para usarlo desde cualquier método.
    // Debe estar descomentado para subir la solución a aceptaelreto.com
    private static Scanner sc = new Scanner(System.in);

    // Versión para probar casos de prueba del enunciado.
    // Solo para pruebas. No subir a aceptaelreto.com sin comentar esta línea.
    // private static Scanner sc = new Scanner("5 4\n.NNNN\nN...N\n.NNN.\n.....\n5 3\n.NNNN\nNN...\nNN...\n");

    // Array bidimensional para representar el terreno. Una celda "true" significa que se pueden montar vías.
    private static boolean[][] terreno;
    // Array bidimensional para ir marcando celdas ya visitadas, para evitar ciclos al aplicar BFS.
    private static boolean[][] visitados;
    // Array bidimensional para ir almacenando las distancias recorridas al recorrer el mapa (grafo) con BFS.
    private static int[][] distancias;
    // Número de filas del mapa.
    private static int numFilas;
    // Número de columnas del mapa.
    private static int numColumnas;

    public static void main(String[] args) throws InterruptedException {
        // Se procesan casos mientras haya datos que leer.
        while (sc.hasNext()) {

            procesarCaso();
        }
    }

    /**
     * Procesa un caso: leer filas y columnas, inicializar arrays bidimensionales, leer mapa, y aplicar BFS.
     */
    private static void procesarCaso() {
        // Leer filas y columnas
        numColumnas = sc.nextInt();
        numFilas = sc.nextInt();

        // Consumir el \n que queda, porque después se va a leer texto con nextLine()
        sc.nextLine();

        // Inicializar arrays
        terreno = new boolean[numFilas][numColumnas];
        visitados = new boolean[numFilas][numColumnas];
        distancias = new int[numFilas][numColumnas];

        // Leer las celdas de la entrada, modificando el array "terreno"
        leerCeldas();

        // Casos límite: no se puede montar vía en inicio o fin.
        if (!terreno[0][0] || !terreno[numFilas - 1][numColumnas - 1]) {
            System.out.println("IMPOSIBLE");
        } else {
            // Caso "estándar": se aplica BFS.
            long menorLongitud = buscarCaminoBfs();
            System.out.println((menorLongitud == -1) ? "IMPOSIBLE" : menorLongitud);
        }
    }

    /**
     * Realiza la búsqueda siguiendo el algoritmo BFS
     * @return la longitud del camino mínimo (que en BFS es el primero que se encuentra),
     * o -1 si no existe un camino.
     */
    private static long buscarCaminoBfs() {
        // Cola de nodos para el algoritmo BFS
        Queue<Celda> cola = new LinkedList<>();

        // Añadir la cola la celda inicial, marcarla como visitada, y establecer
        // la distancia a 1 (porque es el primer tramo de vía)
        Celda inicial = new Celda(0, 0);
        visitados[0][0] = true;
        distancias[0][0] = 1;
        cola.add(inicial);

        // Mientras haya elementos en la cola
        while (!cola.isEmpty()) {
            // Obtener el primer elemento de la cola
            Celda celdaActual = cola.poll();

            // Si es el final, se ha terminado la búsqueda, porque BFS encuentra el
            // camino mínimo siempre, y siempre es el primero encontrado.
            if (celdaActual.estaEn(numFilas - 1, numColumnas - 1)) {
                // Hemos llegado al final. Devolvemos la distancia a este punto.
                return distancias[celdaActual.fila][celdaActual.columna];
            }

            // Añadir a la cola las adyacentes. En aniadirAdyacente se hace el control
            // necesario, y se incrementan las distancias.
            aniadirAdyacente(cola, celdaActual, -1, 0); //N
            aniadirAdyacente(cola, celdaActual, -1, 1); //NE
            aniadirAdyacente(cola, celdaActual, 0, 1); //E
            aniadirAdyacente(cola, celdaActual, 1, 1); //SE
            aniadirAdyacente(cola, celdaActual, 1, 0); //S
            aniadirAdyacente(cola, celdaActual, 1, -1); //SO
            aniadirAdyacente(cola, celdaActual, 0, -1); //O
            aniadirAdyacente(cola, celdaActual, -1, -1); //NO
        }

        // Si no se ha encontraddo nada (se ha vacíado la cola), es que no hay camino posible.
        return -1;
    }

    /**
     * Añade una celda adyacente a otra a la cola de celdas para el algoritmo BFS. Calcula la nueva
     * celda a partir de la celda origen, y el incremento / decremento en fila / columna.
     * Solo añade la celda a la cola si se cumplen las siguientes condiciones:
     * - La nueva celda está dentro del tablero.
     * - La nueva celda aún no ha sido visitada
     * - Se puede navegar a esa celda (se puede montar la vía)
     * @param cola La cola con las celdas que hay que procesar
     * @param celdaActual La celda a partir de la que hay que calcular la nueva celda en la cola.
     * @param variacionFila Incremento o decremento en la fila (-1, 0, 1)
     * @param variacionColumna Incremento o decremento en la columna (-1, 0, 1)
     */
    private static void aniadirAdyacente(Queue<Celda> cola, Celda celdaActual, int variacionFila, int variacionColumna) {
        int nuevaFila = celdaActual.fila + variacionFila;
        int nuevaColumna = celdaActual.columna + variacionColumna;

        if ((nuevaFila >= 0 && nuevaFila < numFilas) && (nuevaColumna >= 0 && nuevaColumna < numColumnas)) {
            // Está dentro del terreno.
            if (!visitados[nuevaFila][nuevaColumna]) {
                // No se ha puesto ya vía
                if (terreno[nuevaFila][nuevaColumna]) {
                    // Se pueden poner vías
                    // Poner vía (marcarla como visitada), calcular distancia, y añadirla a la cola.
                    visitados[nuevaFila][nuevaColumna] = true;
                    distancias[nuevaFila][nuevaColumna] = distancias[celdaActual.fila][celdaActual.columna] + 1;
                    cola.add(new Celda(nuevaFila, nuevaColumna));
                }
            }
        }
    }

    /**
     * Lee las celdas de la entrada estándar y rellena el array del mapa
     */
    private static void leerCeldas() {
        for (int fila = 0; fila < numFilas; fila++) {
            String contenidoFila = sc.nextLine();
            for (int columna = 0; columna < numColumnas; columna++) {
                char marcador = contenidoFila.charAt(columna);
                terreno[fila][columna] = marcador == '.';
            }
        }
    }

    /**
     * Clase auxiliar para poder meter en la cola del algoritmo BFS las casillas del mapa que se tienen que navegar.
     */
    private static class Celda {
        private final int fila;
        private final int columna;

        private Celda(int fila, int columna) {
            this.fila = fila;
            this.columna = columna;
        }

        public boolean estaEn(int fila, int columna) {
            return this.fila == fila && this.columna == columna;
        }
    }
}
