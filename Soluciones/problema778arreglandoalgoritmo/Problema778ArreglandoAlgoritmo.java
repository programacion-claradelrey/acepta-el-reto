import java.util.Scanner;

/**
 * En este problema la forma más "intuitiva" de resolverlo es crear un array en
 * el que se guardan todos los números, y se recorre de atrás hacia adelante
 * hasta que se encuentra un valor que no es mayor que los anteriores.
 * Además de que esto no es del todo correcto (puede parecer ordenado, pero
 * haber valores que no estén bien colocados, como en el segundo caso), antes de
 * que se produzca un WA (Worng Answer), se produce un MLE (Memory Limit
 * Exceeded). En esta clase está el método basado en array, que no es correcto,
 * además de producir MLE, y el que sí lo es.
 */
public class Problema778ArreglandoAlgoritmo {
    // Atributo estático, para usarlo desde cualquier método.
    // Debe estar descomentado para subir la solución a aceptaelreto.com
    private static Scanner sc = new Scanner(System.in);

    // Versión para probar casos de prueba del enunciado.
    // Solo para pruebas. No subir a aceptaelreto.com sin comentar esta línea.
    // private static Scanner sc = new Scanner("""
    // 4
    // 1 2 2 3
    // 6
    // 5 4 6 7 8 9
    // 0
    // """);

    public static void main(String[] args) {
        // Leer número de tramos del caso, y repetir hasta
        // que el número de elementos sea cero.
        int numElementos;
        while ((numElementos = sc.nextInt()) != 0) {
            procesarCaso(numElementos);
        }
    }

    private static void procesarCaso(int numElementos) {
        // Valor máximo encontrado hasta el momento.
        // Necesario para verificar que la serie de números que se contabiliza
        // siempre es mayor que el último máximo encontrado. Es para evitar
        // el problema del segundo caso de prueba, en el que 5 4 6 7 8 9 está
        // ordenado desde el 6 y no desde el 4, porque cuatro no es > 5
        long ultimoMaximoRelativo = Long.MIN_VALUE;

        // Longitud de la serie de números ordenados.
        int longitudSerie = 0;

        // Leer número a número.
        for (int i = 0; i < numElementos; i++) {

            // Leer número
            long valorActual = sc.nextLong();

            if (valorActual >= ultimoMaximoRelativo) {
                // Si el número leído es mayor o igual que el último máximo,
                // se toma como nuevo máximo, y se cuenta el número como parte de la serie
                ultimoMaximoRelativo = valorActual;
                longitudSerie++;
            } else {
                // Si se ha "bajado", es que la serie se ha roto.
                longitudSerie = 0;
            }

        }

        // Mostrar longitud de la serie.
        System.out.println(longitudSerie);
    }

    /**
     * Solución que APARENTEMENTE funciona, pero que obtiene veredicto MLE (Memory
     * Limi Exceeded). Esto es porque el array de long puede ser muy grande. La
     * memoria máxima permitida es 4 kilobytes (4096 bytes). Como cada long en Java
     * son 8 bytes, podríamos almacenar 4096/8 = 512 números long. Muy poco para los
     * casos de prueba que se ejecutarán. Hay que optar por un enfoque en el que no
     * se almacene nada en memoria, descartando valores a medida que se van leyendo.
     * Además, no es correcto porque no tiene en cuenta situaciones en las que un
     * elemento puede parecer colocado en su sitio, cuando en realidad no lo está,
     * porque en posiciones inferiores del array hay números mayores, que deberían
     * ocupar el lugar de ese elemento.
     * 
     * @param numElementos número de elementos del caso de prueba
     */
    private static void procesarCasoMle(int numElementos) {
        long mayorElemento = Long.MIN_VALUE;

        long[] elementos = new long[numElementos];
        for (int i = 0; i < elementos.length; i++) {
            long elemento = sc.nextLong();
            if (elemento > mayorElemento) {
                mayorElemento = elemento;
            }
            elementos[i] = elemento;
        }

        int numElementosOrdenados = 0;
        if (elementos[elementos.length - 1] == mayorElemento) {
            int i;
            for (i = elementos.length - 1; (i > 0) && (elementos[i] >= elementos[i - 1]); i--) {
                numElementosOrdenados++;
            }
            if (i == 0) {
                numElementosOrdenados++;
            }
        }

        System.out.println(numElementosOrdenados);
    }

}