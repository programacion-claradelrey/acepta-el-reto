package es.claradelrey.aceptaelreto.problema247saliendocrisis;

import java.util.Scanner;

/**
 * https://www.aceptaelreto.com/problem/statement.php?id=247
 */
public class Problema247SaliendoCrisis {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// Variable para guardar el número de datos a evaluar
		int numDatos;
		// Leemos el número de datos, y mientras no sea 0, procesamos el caso
		while ((numDatos = sc.nextInt()) != 0) {
			// Tenemos que leer todos los datos del caso, y comprobar que la progresión es
			// siempre creciente.

			// Variable para guardar el valor anterior. La inicializamos con cero, porque
			// las mediciones siempre son, como mínimo, 1
			int valorAnterior = 0;

			// Variable para guardar si hemos detectado un valor que decrece. Inicializamos
			// a false porque asumimos que no lo hay, pero pasaremos a true si lo hay.
			boolean haDecrecido = false;

			// Leemos todos los datos y comparamos en cada ciclo
			for (int i = 0; i < numDatos; i++) {
				int nuevoValor = sc.nextInt();
				if (nuevoValor <= valorAnterior) {
					haDecrecido = true;
				}
				valorAnterior = nuevoValor;
			}

			System.out.println(haDecrecido ? "NO" : "SI");
		}
	}
}
