package es.claradelrey.aceptaelreto.plantillas;

import java.util.Scanner;

/**
 * 
 * Plantilla de programa para solucionar los problemas de Acepta el Reto que hay
 * que procesar hasta que se acabe la entrada. Estos casos son más complicados
 * de probar con la consola, porque hasta que no se ha cerrado no se detecta el
 * fin de la entrada. Es muy habitual que cuando probemos estos problemas el
 * programa siga esperando entrada cuando ya ha procesado todo. En realidad
 * cuando se ejecutan casos de prueba en el juez en línea esto no es un
 * problema.
 *
 */

// Ejemplos de problemas con este tipo de control de entrada:
// - https://www.aceptaelreto.com/problem/statement.php?id=649
//   Multitarea
// - https://www.aceptaelreto.com/problem/statement.php?id=620
//   Juegos en cintas

public class PlantillaFinDeEntrada {

	// Creamos el Scanner como estático a nivel de clase para no tener que pasarlo
	// como parámetro en métodos y para no tener que controlar el cierre con
	// try-with-resources
	private static Scanner scanner = new Scanner(System.in);

	// Alternativa para probar estos casos de prueba: usar una String con saltos de
	// línea con el caso de prueba como parámetro para el scanner. Ojo, no olvidar
	// cambiarlo por un Scanner que lea de System.in antes de subir el problema al
	// juez. Este ejemplo de entrada sería para el problema 649 - Multitarea
	private static Scanner scannerAlternativo = new Scanner(
			"2 0 10\n2 5\n4 6\n0 2 100\n1 4 8\n5 7 8\n2 1 10\n8 20\n1 5\n6 7 10");

	public static void main(String[] args) {
		// Mientras haya entrada, procesamos casos
		// Ejemplo usando el objeto scannerAlternativo, con el contenido del problema
		// 649
		while (scannerAlternativo.hasNext()) {
			// No procesamos el caso, porque es un ejemplo, pero hacemos las lecturas y
			// mostramos mensajes para comprobar que funciona.

			// Variables para la entrada de datos
			int numTareasUnicas = scannerAlternativo.nextInt();
			int numTareasPeriodicas = scannerAlternativo.nextInt();
			int minutosAEvaluar = scannerAlternativo.nextInt();

			// Tareas únicas
			for (int i = 0; i < numTareasUnicas; i++) {
				int inicio = scannerAlternativo.nextInt();
				int fin = scannerAlternativo.nextInt();
			}

			// Tareas periódicas.
			for (int i = 0; i < numTareasPeriodicas; i++) {
				int inicio = scannerAlternativo.nextInt();
				int fin = scannerAlternativo.nextInt();
				int periodo = scannerAlternativo.nextInt();
			}

			System.out.println("Procesado un caso.");
		}

		// Bucle genérico para procesar estos casos. Comentar este bucle si se quiere
		// probar el ejemplo anterior con datos del problema 649
		while (scanner.hasNext()) {
			// Leer y procesar caso
		}
	}
}
