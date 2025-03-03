

import java.util.Scanner;

/**
 * Posible solución al problema 607 de Acepta el Reto. Esta solución se basa en
 * que el número de líneas copiadas se multiplica por dos cada copia,
 * obteneniendo la siguiente secuencia: 1, 2, 4, 8, 16, 32, 64, 128, ... Esto
 * son las potencias de dos, por lo que podemos usarlas para calcular cuantas
 * líneas se tienen en cada iteración. Para evitar usar Math.pow, que puede ser
 * más lenta que una simple multiplicación, en lugar de usar siempre potencia,
 * se puede multiplicar por dos e ir manteniendo el último resultado.
 */
public class Problema607MinimCastigo {
	private static final Scanner scanner = new Scanner(System.in);

	// Para probar el caso de uso de Acepta el Reto, descomentar esta línea y
	// comentar la anterior.
	// private static final Scanner scanner = new Scanner("4\r\n1\r\n2\r\n3\r\n4");

	public static void main(String[] args) {
		// Lectura de número de casos, y bucle para procesar los casos uno a uno
		int numCasos = Integer.parseInt(scanner.nextLine());
		while (numCasos-- > 0) {
			int numLineas = Integer.parseInt(scanner.nextLine());
			System.out.println(calcularNumeroCopias(numLineas));
		}
	}

	/**
	 * Método para procesar un caso
	 * 
	 * @param numLineas el número de líneas que debe escribir el alumno castigado
	 * @return número de copias que se tienen que realizar para conseguir el número
	 *         de líneas
	 */
	private static long calcularNumeroCopias(int numLineas) {
		// Caso particular: si es una línea no hay que hacer copias
		if (numLineas == 1) {
			return 0;
		}

		// Como al menos hay dos líneas, partimos de que hay una copia y dos líneas
		int numCopias = 1;
		int numLineasCopiadas = 2;
		// Mientras que no tengamos líneas suficientes, seguiremos cortando, pegando y
		// copiando.
		while (numLineasCopiadas < numLineas) {
			// Incrementamos el número de copias
			numCopias++;
			// Calculamos el número de líneas copiadas, que es el doble que había
			numLineasCopiadas *= 2;
		}
		// Devolvemos el número de copias.
		return numCopias;
	}
}
