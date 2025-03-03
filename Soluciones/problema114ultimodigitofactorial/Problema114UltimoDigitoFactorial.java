import java.util.Scanner;

// La aproximación más obvia de este problema es hacer una función factorial, 
// usarla para calcular el factorial de los números, y obtener el último dígito.
// El problema es que la función factorial, sea recursiva o iterativa, va a tardar 
// demasiado, y el problema fallará con RTE (run time exceeded).
// Si se analiza la secuencia del factorial para 0, 1, 2, 3, 4, 5, 6, etc. se obtiene:
// 1, 1, 2, 6, 24, 120, 720. Si seguimos, todos los factoriales de n para n > 4 terminan en cero.
// Así que es más fácil usar unos if que hacer el cálculo cada vez.

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
			return 1; // Para el 0 y el 1
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
