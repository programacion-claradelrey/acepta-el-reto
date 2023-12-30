package es.claradelrey.aceptaelreto.resueltos.problema364espionajenavidad;

import java.util.Scanner;

public class Problema364EspionajeNavidad {
	public static void main(String[] args) {
		// Caso de prueba del enunciado
		// Scanner scanner = new Scanner("QUERIDOS REYES MAGOS\n"
		// + "HE SIDO MUY PERO QUE MUY BUENO\n"
		// + "Y QUIERO QUE ME TRAIGAIS UNA ZAMBOMBA\n"
		// + "FIN\n");
		Scanner scanner = new Scanner(System.in);

		// Leemos línea
		String linea = scanner.nextLine();
		// Salimos cuando la línea sea "FIN"
		while (!linea.equals("FIN")) {
			for (char c : linea.toCharArray()) {
				// Cada caracter de la línea tenemos que codificarlo, pero sólo si son distintos
				// a espacio. Si es la Z, tenemos que "dar la vuelta" y cambiarla por la A
				if (c != ' ') {
					if (c == 'Z') {
						c = 'A';
					} else {
						c++;
					}
				}
				// Mostramos el caracter codificado.
				System.out.print(c);
			}
			// Mostramos salto de línea, porque el método nextLine de Scanner elimina el
			// salto de línea
			System.out.println();

			// Leemos siguiente línea
			linea = scanner.nextLine();
		}
	}
}
