package es.claradelrey.aceptaelreto.plantillas;

import java.util.Scanner;

/**
 * 
 * Plantilla de programa para solucionar los problemas de Acepta el Reto que hay
 * que procesar hasta que se encuentre un caso especial que no hay que procesar.
 * Cada problema es un poco distinto, porque puede que haya que encontrar una
 * cadena de texto (String) específica, o en otros sea un número. En el código
 * se ven dos ejemplos, uno en el que se busca una cadena "FIN" y otro en el que
 * se busca el entero "0"
 *
 */

// Ejemplos de problemas con este tipo de control de entrada:
// - https://www.aceptaelreto.com/problem/statement.php?id=333
//   Números bicapicua
// - https://www.aceptaelreto.com/problem/statement.php?id=148
//   Nochevieja
// - https://www.aceptaelreto.com/problem/statement.php?id=130
//   Mejor ... imposible
public class PlantillaCasoFinal {

	// Creamos el Scanner como estático a nivel de clase para no tener que pasarlo
	// como parámetro en métodos y para no tener que controlar el cierre con
	// try-with-resources
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		// Ejemplo 1: procesamos casos hasta que se lea la cadena "FIN".
		// Se hace una comparación case-sensitive para que conicida exactamente con
		// "FIN"
		// Leemos el valor de entrada, y sobre la marcha comparamos con la cadena que
		// provoca el fin del programa.
		String texto;
		while (!(texto = scanner.nextLine()).equals("FIN")) {
			// TODO Procesar caso. Puede implicar leer más líneas. Depende del problema.
		}

		// Ejemplo 2: procesamos casos hasta que se lea el número 0.
		// Leemos el valor de entrada, y sobre la marcha comparamos con cero, que
		// provoca el fin del programa. La lectura puede ser mejor hacerla con nextInt
		// si el dato numérico está acompañado en la misma línea con otros valores.
		int numero;
		while ((numero = Integer.parseInt(scanner.nextLine())) != 0) {
			// TODO Procesar caso. Puede implicar leer más líneas. Depende del problema.
		}
	}
}
