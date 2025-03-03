

import java.util.Scanner;

// Enfoque completamente distinto. Para evitar las búsquedas, se procesará el array 
// de números de la siguiente forma:
// Comenzando por el principio y avanzando hacia el final, vamos quedándonos con el 
// mayor valor, y aplicando el algoritmo sobre las posiciones pares.
// Del mismo modo, empezando por el final, nos vamos quedando con el menor, y 
// aplicando el algoritmo sobre las posiciones impares. 
// Así pasamos de hacer múltiples recorridos del array (no cuadrática pero casi)
// a hacer dos recorridos. Pasamos de n² a 2n
// La mejora no es relevante en este caso (0.582 vs 0.607), pero es el tipo de cosas 
// que pueden hacer que un problema que da TLE funcione. 
public class Problema711VerificacionEntradasV3 {

	private static Scanner scanner = new Scanner(System.in);
//	 private static Scanner scanner = new Scanner("3\n" + "7214\n" + "10\n" +
//	 "1001\n" + "");

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

		// Primero del principio a fin, aplicándolo sólo a las posiciones pares
		int mayorDigito = digitos[0];
		for (int posicion = 0; posicion < digitos.length; posicion++) {
			// Sólo hacemos el cálculo en posiciones pares
			if (posicion % 2 != 0) {
				sumaVerificacion += (digitos[posicion] * 2) + mayorDigito;
			}
			// En cualquier caso, sea posición par o no, nos quedamos con el mayor dígito
			mayorDigito = Math.max(mayorDigito, digitos[posicion]);
		}

		// Repetimos recorriéndolo del final al principio
		int menorDigito = digitos[digitos.length - 1];
		for (int posicion = digitos.length - 1; posicion >= 0; posicion--) {
			// Sólo hacemos el cálculo en posiciones impares
			if (posicion % 2 == 0) {
				sumaVerificacion += (digitos[posicion] * 3) + menorDigito;
			}
			// En cualquier caso, sea posición impar o no, nos quedamos con el menor dígito
			menorDigito = Math.min(menorDigito, digitos[posicion]);
		}

		System.out.println(sumaVerificacion);

	}
}
