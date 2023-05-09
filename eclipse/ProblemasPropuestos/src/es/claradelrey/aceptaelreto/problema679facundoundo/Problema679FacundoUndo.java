package es.claradelrey.aceptaelreto.problema679facundoundo;

import java.util.LinkedList;
import java.util.Scanner;

public class Problema679FacundoUndo {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int numCasos = Integer.parseInt(scanner.nextLine());

		while (numCasos > 0) {
			procesarCaso();
			numCasos--;
		}
	}

	private static void procesarCaso() {
		LinkedList<String> palabrasEscritas = new LinkedList<>();
		LinkedList<String> palabrasDeshechas = new LinkedList<>();

		String palabra;
		while (!(palabra = scanner.next()).equals(".")) {
			if (palabra.equals("<")) {
				// Hacer undo. Sólo podemos hacerlo si hay palabras en las palabras escritas.
				if (!palabrasEscritas.isEmpty()) {
					palabrasDeshechas.offer(palabrasEscritas.removeLast());
				}
			} else if (palabra.equals(">")) {
				// Hacer redo. 
				if (!palabrasDeshechas.isEmpty()) {
					// Primer caso: si hay palabras en las palabras deshechas.
					palabrasEscritas.offer(palabrasDeshechas.removeLast());
				} else if (!palabrasEscritas.isEmpty()) {
					// Segundo caso: como no quedan deshechas, usamos la última escrita, si hay
					palabrasEscritas.offer(palabrasEscritas.getLast());
				}
			} else {
				// Palabra normal, se añade a las palabras escritas.
				palabrasEscritas.offer(palabra);
				// Cuando escribimos una nueva palabra se olvidan las deshechas
				palabrasDeshechas.clear();
			}
		}

		// Al terminar, tenemos que mostrar todas las palabras separadas por espacios
		while (!palabrasEscritas.isEmpty()) {
			palabra = palabrasEscritas.removeFirst();
			System.out.print(palabra);
			if (!palabrasEscritas.isEmpty()) {
				System.out.print(" ");
			}
		}
		// Y salto de línea final
		System.out.println();
	}
}
