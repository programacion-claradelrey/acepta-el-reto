package es.claradelrey.aceptaelreto.resueltos.problema100kaprekar;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Problema100Kaprekar {

	private static final String CONSTANTE_KAPREKAR = "6174";

	private static Scanner scanner = new Scanner(System.in);
	// private static Scanner scanner = new Scanner("5\n" + "3524\n" + "1111\n" +
	// "1121\n" + "6174\n" + "1893");

	public static void main(String[] args) {

		int numCasos = Integer.parseInt(scanner.nextLine());

		while (numCasos > 0) {
			// Convertimos a String con todos los dígitos, porque para ordenar e invertir
			// hay que tener los cuatro dígitos, aunque sean ceros.
			String numero = String.format("%04d", Integer.parseInt(scanner.nextLine()));
			if (numero.equals(CONSTANTE_KAPREKAR)) {
				// Si el número es la constante, lo hemos logrado en cero iteraciones.
				System.out.println(0);
			} else if (esRepDigits(numero)) {
				// Si el número está formado por dígitos repetidos, no se puede llegar.
				System.out.println(8);
			} else {
				// Para el resto, calculamos iteraciones.
				System.out.println(calcularIteraciones(numero));
			}
			numCasos--;
		}
	}

	/**
	 * Permite saber si un número de cuatro cifras tiene todas sus cifras iguales.
	 * 
	 * @param numero número de cuatro digitos (obligatoriamente) que queremos
	 *               comprobar.
	 * @return true si todas sus cifras son iguales, false en caso contrario.
	 */
	private static boolean esRepDigits(String numero) {
		char digitoControl = numero.charAt(0);
		if (numero.charAt(1) != digitoControl)
			return false;
		if (numero.charAt(2) != digitoControl)
			return false;
		if (numero.charAt(3) != digitoControl)
			return false;
		return true;
	}

	/**
	 * Calcula las iteraciones necesarias para llegar a la constate de Kaprekar.
	 * 
	 * @param numero número del que partimos para llegar a la constante.
	 * @return el número de iteraciones (ordenación de dígitos, inversión y resta)
	 *         necesarias para llegar a la constante
	 */
	private static int calcularIteraciones(String numero) {
		int numIteraciones = 0;

		do {
			// Obtenemos el primer número (cifras ordenadas ascendentemente)
			int numAscendente = ordenarYConvertir(numero);
			// Obtenemos el segundo (cifras ordenadas descendentemente)
			int numDescendente = ordenarDescendenteYConvertir(numero);
			// Hacemos la resta (usamos ABS para no tener que evaluar cuál es el mayor de
			// los dos) y lo volvemos a convertir a String para comparar con la constante y
			// volver a iterar si es necesario
			numero = String.format("%04d", Math.abs(Integer.valueOf(numAscendente) - Integer.valueOf(numDescendente)));
			numIteraciones++;
		} while (!numero.equals(CONSTANTE_KAPREKAR));

		return numIteraciones;
	}

	/**
	 * Ordena ascendentemente las cifras de un número que se recibe como String, y
	 * devuelve su valor como entero.
	 * 
	 * @param numero la cadena (String) que representa el número cuyas cifras
	 *               queremos ordenar ascendentemente para luego convertirlo
	 * @return el número (int) formado por las cifras recibidas, ordenadas
	 *         ascendentemente.
	 */
	private static int ordenarYConvertir(String numero) {
		char[] num = numero.toCharArray();
		Arrays.sort(num);
		return Integer.parseInt(String.valueOf(num));
	}

	/**
	 * Ordena ascendentemente, y luego invierte las cifras de un número que se
	 * recibe como String, y devuelve su valor como entero.
	 * 
	 * @param numero la cadena (String) que representa el número cuyas cifras
	 *               queremos ordenar ascendentemente para luego convertirlo. Tiene
	 *               que ser necesariamente de cuatro cifras.
	 * @return el número (int) formado por las cifras recibidas, ordenadas
	 *         ascendentemente.
	 */
	private static int ordenarDescendenteYConvertir(String numero) {
		char[] num = numero.toCharArray();
		Arrays.sort(num);
		// La inversión se hace así, no ordenando descendentemente, porque en versiones
		// antiguas de SDK puede que no funcione Arrays.sort(array,
		// Collections.reverseOrder())
		char c = num[0];
		num[0] = num[3];
		num[3] = c;
		c = num[1];
		num[1] = num[2];
		num[2] = c;
		return Integer.parseInt(String.valueOf(num));
	}

}
