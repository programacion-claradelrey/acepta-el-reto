package es.claradelrey.aceptaelreto.plantillas;

import java.util.Scanner;

/**
 * 
 * Plantilla de programa para solucionar los problemas de Acepta el Reto que
 * comienzan con el número de casos que hay que procesar
 * 
 */

// Ejemplos de problemas con este tipo de control de entrada:
// - https://www.aceptaelreto.com/problem/statement.php?id=114 
//	 Último dígito del factorial
// - https://www.aceptaelreto.com/problem/statement.php?id=117
//	 La fiesta aburrida
// - https://www.aceptaelreto.com/problem/statement.php?id=474
//   Tu amigable vecino

public class PlantillaNumeroCasos {

	// Creamos el Scanner como estático a nivel de clase para no tener que pasarlo
	// como parámetro en métodos y para no tener que controlar el cierre con
	// try-with-resources
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		// Leemos el número de casos, que aparece en la primera línea, y lo convertimos
		// a entero
		int numCasos = Integer.parseInt(scanner.nextLine());

		// Dos opciones, con while y con for. Eliminar la que no se quiera usar.

		// Opción 1: bucle while
		while (numCasos > 0) {
			// TODO Leer y procesar caso
			numCasos--;
		}

		// Opción 2: bucle for
		for (int i = 0; i < numCasos; i++) {
			// TODO Leer y procesar caso
		}
	}

}
