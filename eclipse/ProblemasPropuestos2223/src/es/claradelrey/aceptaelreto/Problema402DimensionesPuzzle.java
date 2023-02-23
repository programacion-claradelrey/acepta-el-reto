package es.claradelrey.aceptaelreto;

import java.util.Scanner;

/**
 * Problema https://www.aceptaelreto.com/problem/mysubmissions.php?id=402
 */
public class Problema402DimensionesPuzzle {
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			// Variable para guardar el número de piezas leidas del caso de prueba
			int numPiezas;
			// Leemos el número de piezas, y mientras no sea 0, procesamos el caso
			while ((numPiezas = Integer.parseInt(sc.nextLine())) != 0) {
				// El problema indica que la mejor solución es aquella en la que el alto y el
				// ancho son lo más próximos posible. El caso ideal es que el alto y el ancho
				// sean iguales, es decir, sea un cuadrado y el número de piezas sea el cuadrado
				// del lado. O lo que es lo mismo los dos lados la raíz cuadrada del número de
				// piezas.
				int ladoMenor = (int) Math.sqrt(numPiezas);
				int resto;
				resto = numPiezas % ladoMenor;
				// Mientras que el producto de los dos lados 
				while (resto != 0) {
					ladoMenor--;
					resto = numPiezas % ladoMenor;
				}
				System.out.println(numPiezas / ladoMenor);
			}
		}
	}
}
