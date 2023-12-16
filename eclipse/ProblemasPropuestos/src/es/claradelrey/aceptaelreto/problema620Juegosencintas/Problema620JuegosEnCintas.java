package es.claradelrey.aceptaelreto.problema620Juegosencintas;

import java.util.Scanner;

public class Problema620JuegosEnCintas {
	public static void main(String[] args) {
		// Para probar los casos de prueba del enunciado
		// Scanner scanner = new Scanner("10 4\r\n" + //
		// "7 7 3 3\r\n" + //
		// "10 3\r\n" + //
		// "4 7 7\r\n" + //
		// "");
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {

			int duracionCara = scanner.nextInt();
			int numJuegos = scanner.nextInt();
			int[] duracionesJuegos = new int[numJuegos];
			for (int i = 0; i < duracionesJuegos.length; i++) {
				duracionesJuegos[i] = scanner.nextInt();
			}
			if (haySolucion(duracionesJuegos, duracionCara, 0, 0, 0)) {
				System.out.println("SI");
			} else {
				System.out.println("NO");
			}

		}
	}

	// Este método recursivo utiliza backtraking para buscar la solución.
	// Acumula juegos en las caras, y si encuentra que se ha llenado alguna de las
	// caras, vuelve atrás y prueba de otra forma, cambiando los juegos que se
	// guardan en cada cara.
	private static boolean haySolucion(int[] duracionesJuegos, long duracionCara, int posicionActual, long sumaA,
			long sumaB) {

		// Si hemos llegado al final, hemos colococado todos los juegos, y la solución
		// será correcta si ambas sumas caben en cada cara
		if (posicionActual == duracionesJuegos.length) {
			return ((sumaA <= duracionCara) && (sumaB <= duracionCara));
		}
		// Si cualquiera de las dos sumas se ha pasado, podemos devolver false aunque no
		// hayamos llegado al final, porque no podremos añadir más juegos sin pasarnos.
		// Este es el punto donde se hace backtraking, porque volvemos atrás devolviendo
		// false, para que quién llamó al método pruebe algo distinto.
		if ((sumaA > duracionCara) || (sumaB > duracionCara)) {
			return false;
		}

		// Si no hemos llegado al final (quedan juegos por guardar) y no nos hemos
		// pasado aún (no se han llenado las caras), tenemos que probar dos opciones:
		// 1.- Meter el juego que toca en la cara A y seguir adelante con el siguiente.
		// 2.- Si la 1 no ha funcionado, meter el que toca en la cara B y seguir con el
		// siguiente.
		// Este es el punto donde se hace la recursividad: el método se llama a si
		// mismo, una o dos veces, depende de si se encuentra la solución en la primera
		// llamada.
		if (haySolucion(duracionesJuegos, duracionCara, posicionActual + 1, sumaA + duracionesJuegos[posicionActual],
				sumaB)) {
			return true;
		}

		return haySolucion(duracionesJuegos, duracionCara, posicionActual + 1, sumaA,
				sumaB + duracionesJuegos[posicionActual]);

	}
}
