

import java.util.Scanner;

public class Problema694Acronimos {
	private static Scanner scanner = new Scanner(System.in);
//	private static Scanner scanner = new Scanner(
//			"4\nLight Amplification by Stimulated Emission of Radiation\nObjeto Volador NO Identificado\nTren Articulado Ligero GOICOECHEA ORIOL\nUnited Nations Educational Scientific and Cultural Organization");

	public static void main(String[] args) {
		int numCasos = Integer.parseInt(scanner.nextLine());
		while (numCasos > 0) {
			String linea = scanner.nextLine();
			// Dividimos la línea en palabras. Podemos hacerlo con el espacio porque nos
			// dice el enunciado que sólo se separan por espacios.
			String[] palabras = linea.split(" ");
			for (String palabra : palabras) {
				// Por si acaso había varios espacios separando palabras, para evitar
				// StringIndexOutOfBoundException al llamar a charAt, comprobamos que la palabra
				// tiene al menos una letra.
				if (palabra.length() > 0) {
					// Extraemos el caracter inicial, y si es mayúscula, lo mostramos
					char inicial = palabra.charAt(0);
					if (Character.isUpperCase(inicial)) {
						System.out.print(inicial);
					}
				}
			}
			// Tras terminar cada línea hay que añadir un salto de línea 
			System.out.println();
			numCasos--;
		}
	}
}
