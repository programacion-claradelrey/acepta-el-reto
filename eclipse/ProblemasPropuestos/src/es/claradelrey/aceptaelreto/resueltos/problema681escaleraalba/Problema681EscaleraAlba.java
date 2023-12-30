package es.claradelrey.aceptaelreto.resueltos.problema681escaleraalba;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Problema681EscaleraAlba {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		// Mientras haya algo que procesar...
		while (scanner.hasNext()) {
			// Leer número de colores
			int numColores = scanner.nextInt();

			long totalPiezas = 0;

			// Si el número de colores es 0, no tenemos que hacer nada más
			if (numColores > 0) {

				// Creamos un array de enteros para la cantidad de piezas de cada color
				Integer[] colores = new Integer[numColores];

				// Leemos las piezas de cada color
				for (int i = 0; i < numColores; i++) {
					colores[i] = scanner.nextInt();
				}

				// Ordenamos los colores en función del número de piezas.
				// Primero los colores con más piezas.
				Arrays.sort(colores, Collections.reverseOrder());

				// Recorremos el array, sumando las piezas, y ajustando los valores a medida que
				// avanzamos, para que un piso tenga siempre menos piezas que el anterior.
				// Cuando llegamos a 0, hemos acabado
				// Empezamos con la primera pieza, que siempre existe, y a partir de ahí vamos
				// sumando.
				int piezasColorActual = colores[0]; // El primero siempre existe.
				totalPiezas = piezasColorActual; // El total al comenzar es igual al número de piezas del primer color.
				int colorActual = 1; // Como hemos contado ya el primero (0), empezamos en el segundo
				while (colorActual < numColores && piezasColorActual > 0) {
					int piezasColorAnterior = piezasColorActual;
					piezasColorActual = colores[colorActual];
					// Si las piezas del siguiente color son las mismas o más que las que usamos en
					// el color anterior, usamos las mismas que el anterior menos una, y el restro
					// se descartan.
					if (piezasColorActual >= piezasColorAnterior) {
						piezasColorActual = piezasColorAnterior - 1;
					}
					// Acumulamos el total y pasamos al siguiente color.
					totalPiezas += piezasColorActual;
					colorActual++;
				}
			}
			System.out.println(totalPiezas);
		}

	}
}
