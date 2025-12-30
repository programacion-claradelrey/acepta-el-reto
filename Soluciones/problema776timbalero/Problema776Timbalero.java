import java.util.Arrays;
import java.util.Scanner;

public class Problema776Timbalero {
    // Atributo estático, para usarlo desde cualquier método.
    // Debe estar descomentado para subir la solución a aceptaelreto.com
    private static Scanner sc = new Scanner(System.in);

    // Versión para probar casos de prueba del enunciado.
    // Solo para pruebas. No subir a aceptaelreto.com sin comentar esta línea.
    // private static Scanner sc = new Scanner("2\n5 10 35 40\n7 20 21 25 37 0\n3\n1 10 12 12 15 20\n4 11 12 0\n0\n");

    public static void main(String[] args) {
        int numPasajes;
        while ((numPasajes = sc.nextInt()) != 0) {
            procesarCaso(numPasajes);
        }
    }

    private static void procesarCaso(int numPasajes) {
        // Hay dos compases (inicial y final) por cada pasaje.
        long[] compasesTimbal = new long[numPasajes * 2];

        // Leer los compases de los pasajes, y guardarlos en array
        for (int i = 0; i < compasesTimbal.length; i++) {
            compasesTimbal[i] = sc.nextInt();
        }

        // Variable para acumular cuantos compases de platillo no están en un pasaje de timbal
        int numCompasesNoSimultaneos = 0;

        // Comenzar a leer compases de platillos, y buscarlos en el array de compases de timbales.
        // Como se garantiza que los pasajes de timbales aparecen en orden (y por tanto los compases), 
        // se puede usar búsqueda binaria (Arrays.binarySearch), que es más eficiente que una búsqueda lineal.
        long compasPlatillo;
        while ((compasPlatillo = sc.nextInt()) != 0) {
            // Buscar compás de platillo en array de compases de timbal.
            int posicionBusqueda = Arrays.binarySearch(compasesTimbal, compasPlatillo);

            // Valorar el valor devuelto.
            if (posicionBusqueda < 0) {
                // Si el valor que devuelve binarySearch es positivo, es que compasPlatillo está en el array.
                // Significa que hay un pasaje de timbales que empieza o termina en ese compás, por lo que ya
                // se sabe que no es posible tocar a la vez el platillo.
                // Si devuelve negativo, binarySearch devuelve (-(punto de inserción) - 1). Esto es:
                // - Si se inserta en la posición 0 -> -1
                // - Si se inserta en la posición 1 -> -2
                // - Si se inserta en la posición 2 -> -3
                // - Si se inserta en la posición 3 -> -4
                // Y así sucesivamente. Si se analiza el valor devuelto, si el punto de inserción se convierte 
                // a un valor positivo, con posicionInsercion = (-posicionBusqueda)-1, podemos deducir que:
                // - Si el valor obtenido es par (posiciones 0, 2, ... del array de compases de pasajes de timbal),
                // se está insertando entre dos pasajes y se debe contabilizar el compás.
                // - Si el valor obtenido es impar, se está insertando dentro de un pasaje de timbal, y no hay que
                // contabilizarlo.
                int posicionInsercion = (-posicionBusqueda) - 1;
                if (posicionInsercion % 2 == 0) {
                    numCompasesNoSimultaneos++;
                }
            }
        }

        System.out.println(numCompasesNoSimultaneos);
    }
}
