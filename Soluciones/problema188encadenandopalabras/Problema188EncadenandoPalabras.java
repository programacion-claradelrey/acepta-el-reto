

import java.util.Scanner;

/**
 * Versión A. Usa String y los métodos de la clase String.
 */
public class Problema188EncadenandoPalabras {

	private static Scanner scanner = new Scanner(System.in);
//	private static Scanner scanner = new Scanner("gugutata\n" + "mata tapa papa pato\n" + "seto taco coma matute\n"
//			+ "sien encima mapa patuco comida\n" + "cata tasama malote tejaba batama\n" + "kiosko comida");

	public static void main(String[] args) {

		while (scanner.hasNextLine()) {
			String linea = scanner.nextLine();
			String[] palabras = linea.split(" ");
			boolean sonEncadenadas = true;
			// El array lo recorremos hasta la penúltima posición. Al acceder a i+1, si lo
			// recorrierámos hasta la última posición lanzaría una excepción.
			for (int i = 0; i < palabras.length - 1 && sonEncadenadas; i++) {
				// En cada iteración comprobamos si una palabra (en posición i+1) es la palabra
				// encadenada de la palabra en la posición anterior (posición i)
				sonEncadenadas = sonEncadenadas(palabras[i], palabras[i + 1]);
			}
			System.out.println(sonEncadenadas ? "SI" : "NO");
		}

	}

	private static boolean sonEncadenadas(String anterior, String posterior) {
		return anterior.substring(anterior.length() - 2).equals(posterior.substring(0, 2));
	}
}
