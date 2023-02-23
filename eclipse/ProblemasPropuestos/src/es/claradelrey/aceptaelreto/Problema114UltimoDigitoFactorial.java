package es.claradelrey.aceptaelreto;

import java.util.Scanner;

/**
 * 
 * Problema https://www.aceptaelreto.com/problem/statement.php?id=114
 *
 */
public class Problema114UltimoDigitoFactorial {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		// Leemos número de casos
		int numCasos = Integer.parseInt(scanner.nextLine());

		// Procesamos caso por caso
		while (numCasos > 0) {
			int numero = Integer.parseInt(scanner.nextLine());
			int ultimoDigito = ultimoDigitoFactorial(numero);
			System.out.println(ultimoDigito);
			numCasos--;
		}

	}

	/**
	 * Calcula el último dígito del factorial de un número
	 * 
	 * @param numero el número de cuyo factorial queremos calcular el último dígito
	 * @return el último dígito del factorial del número
	 */
	private static int ultimoDigitoFactorial(int numero) {
		if (numero < 2)
			return 1;
		if (numero == 2)
			return 2;
		if (numero == 3)
			return 6;
		if (numero == 4)
			return 4; // El factorial de 4 es 24
		// Para el resto de números el factorial siempre acaba en cero
		return 0;
	}

}
