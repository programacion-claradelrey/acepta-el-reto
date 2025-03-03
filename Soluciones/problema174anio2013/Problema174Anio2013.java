

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Posible solución al problema 174 de Acepta el Reto.
 * Esta solución se enfoca en hacer el código lo más legible posible,
 * aunque no sea el más eficiente, o aunque haya partes que sean muy parecidas.
 */

public class Problema174Anio2013 {

    private static Scanner scanner = new Scanner(System.in);

    // Para probar el caso de uso de Acepta el Reto, descomentar esta línea y
    // comentar la anterior.
    // private static Scanner scanner = new Scanner("3\r\n1990\r\n2015\r\n2025");

    public static void main(String[] args) {

        // Lectura de número de casos, y bucle para procesar los casos uno a uno
        int numCasos = Integer.parseInt(scanner.nextLine());
        while (numCasos > 0) {
            int anioCaso = Integer.parseInt(scanner.nextLine());
            procesarCaso(anioCaso);
            numCasos--;
        }

    }

    /**
     * Procesa uno de los casos del problema
     * 
     * @param anio el año que se ha leido en el caso
     */
    private static void procesarCaso(int anio) {
        boolean tieneRepetidos = tieneDigitosRepetidos(anio);
        int anioInicial;
        int tamanioSerie;
        if (tieneRepetidos) {
            // Búsqueda de la solución si se repiten dígitos
            anioInicial = buscarAnioInicioSerieRepetida(anio);
            tamanioSerie = calcularLongitudSerieRepetida(anioInicial);
        } else {
            // Búsqueda de la solución si no se repiten dígitos
            anioInicial = buscarAnioInicioSerieNoRepetida(anio);
            tamanioSerie = calcularLongitudSerieNoRepetida(anioInicial);
        }

        // Mostramos la solución
        System.out.printf("%d %d\n", anioInicial, tamanioSerie);
    }

    /**
     * Determina si un año tiene dígitos repetidos
     * 
     * @param anio el año del que queremos evaluar si tiene repetidos.
     * @return true si el año tiene dígitos repetidos, false en caso contrario.
     * Este método puedeustituirse, si se usan Streams, por una sóla línea:
     * return  list.stream().allMatch(new HashSet<>()::add);
     */
    private static boolean tieneDigitosRepetidos(int anio) {
        List<Integer> digitos = new ArrayList<>();
        // Como no podemos usar métodos modernos como List.of o Streams,
        // tenemos que iterar los dígitos.
        while (anio > 0) {
            int digito = anio % 10;
            digitos.add(digito);
            anio = anio / 10;
        }
        // Nos quedamos con dígitos no repetidos
        Set<Integer> digitosUnicos = new HashSet<>(digitos);
        // Si tras quitar los repetidos tenemos el mismo número de
        // dígitos, es que no hay repetidos.
        return digitos.size() != digitosUnicos.size();
    }

    /**
     * Busca el primer año de una serie de años con dígitos repetidos
     * @param anio el año que sabemos que pertenece a la serie
     * @return el primer año de la serie con dígitos repetidos a la que pertenece anio
     */
    private static int buscarAnioInicioSerieRepetida(int anio) {
        int anioInicial = anio;
        while (tieneDigitosRepetidos(anioInicial)) {
            anioInicial--;
        }
        return anioInicial + 1;
    }

    /**
     * Busca el primer año de una serie de años sin dígitos repetidos
     * @param anio el año que sabemos que pertenece a la serie
     * @return el primer año de la serie sin dígitos repetidos a la que pertenece anio
     */
    private static int buscarAnioInicioSerieNoRepetida(int anio) {
        int anioInicial = anio;
        while (!tieneDigitosRepetidos(anioInicial)) {
            anioInicial--;
        }
        return anioInicial + 1;
    }

    /**
     * Calcula la longitud de una serie con dígitos repetidos
     * @param anioInicial año de inicio de la serie
     * @return la longitud de la serie de años con dígitos repetidos que se inicia con anioInicial 
     */
    private static int calcularLongitudSerieRepetida(int anioInicial) {
        int longitud = 0;
        while (tieneDigitosRepetidos(anioInicial)) {
            longitud++;
            anioInicial++;
        }
        return longitud;
    }

    /**
     * Calcula la longitud de una serie sin dígitos repetidos
     * @param anioInicial año de inicio de la serie
     * @return la longitud de la serie de años sin dígitos repetidos que se inicia con anioInicial 
     */
    private static int calcularLongitudSerieNoRepetida(int anioInicial) {
        int longitud = 0;
        while (!tieneDigitosRepetidos(anioInicial)) {
            longitud++;
            anioInicial++;
        }
        return longitud;
    }
}
