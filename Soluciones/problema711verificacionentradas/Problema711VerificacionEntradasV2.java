

import java.util.Scanner;

// Mejora de la primera aproximación, porque al buscar menores, 
// cuando se encuentra un 0 se para, y al buscar el mayor, al encontrar un 9 se para.
// En realidad, en tiempo de ejecución no ha supuesto diferencia (0.607 vs 0.604)
public class Problema711VerificacionEntradasV2 {

	private static Scanner scanner = new Scanner(System.in);
	// private static Scanner scanner = new Scanner("3\n" + "7214\n" + "10\n" +
	// "1001\n" + "");

	public static void main(String[] args) {

		int numCasos = Integer.parseInt(scanner.nextLine());

		while (numCasos > 0) {
			procesarCaso();
			numCasos--;
		}
	}

	private static void procesarCaso() {
		long numeroEntrada = scanner.nextLong();
		// Convertimos el número a String y de ahí a array de caracteres
		char[] caracteresNumeroEntrada = String.valueOf(numeroEntrada).toCharArray();
		// Creamos un array para almacenar los dígitos, pero como número, no como char,
		// para poder operar matemáticamente
		int[] digitos = new int[caracteresNumeroEntrada.length];
		// Copiamos los caracteres
		for (int i = 0; i < digitos.length; i++) {
			digitos[i] = Character.getNumericValue(caracteresNumeroEntrada[i]);
		}

		procesarCaso(digitos);
	}

	private static void procesarCaso(int[] digitos) {
		// Por si acaso, la suma la almacenaremos en un long
		long sumaVerificacion = 0;
		for (int i = 0; i < digitos.length; i++) {
			// Para evaluar si estamos en posición par o impar hay que "dar la vuelta
			// a la logica". Si consideramos que se cuenta desde la posición 1, como
			// java inicia los arrays en la cero, el cero en realidad será impar, el 1 par
			// (porque corresponde a la dos) y así sucesivamente.
			if (i % 2 == 0) {
				// Posición impar.
				// Buscamos a la derecha de la posición el menor número existente
				int menor = buscarMenorADerecha(digitos, i + 1);
				// Hacemos la operación y lo acumulamos a la suma
				sumaVerificacion += (digitos[i] * 3) + menor;
			} else {
				// Posición par.
				// Buscamos a la izquierda de la posición el mayor número existente
				int mayor = buscarMayorAIzquierda(digitos, i - 1);
				// Hacemos la operación y lo acumulamos a la suma
				sumaVerificacion += (digitos[i] * 2) + mayor;
			}
		}
		System.out.println(sumaVerificacion);

	}

	private static int buscarMenorADerecha(int[] digitos, int posicionInicial) {
		// Asumimos que el primero es el menor.
		int menor = digitos[posicionInicial];
		// Mientras que no llequemos al final del array, o que el dígito menor sea > 0,
		// seguimos buscando. Cuando sea cero paramos, porque no puede haber nada menor
		// que cero.
		for (int posicion = posicionInicial; posicion < digitos.length && menor > 0; posicion++) {
			if (digitos[posicion] < menor) {
				menor = digitos[posicion];
			}
		}
		return menor;
	}

	private static int buscarMayorAIzquierda(int[] digitos, int posicionInicial) {
		// Asumimos que el primero es el mayor.
		int mayor = digitos[posicionInicial];
		// Mientras que no llequemos al principio del array, o que el dígito menor sea <
		// 9, seguimos buscando. Cuando sea 9 paramos, porque no puede haber nada mayor
		// que nueve.
		for (int posicion = posicionInicial; posicion >= 0 && mayor < 9; posicion--) {
			if (digitos[posicion] > mayor) {
				mayor = digitos[posicion];
			}
		}
		return mayor;
	}

}
