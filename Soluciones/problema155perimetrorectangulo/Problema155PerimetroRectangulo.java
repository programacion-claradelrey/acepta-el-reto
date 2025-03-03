

import java.util.Scanner;

/**
 * Problema https://www.aceptaelreto.com/problem/statement.php?id=155
 */
public class Problema155PerimetroRectangulo {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// Variables para leer coordenadas de la esquina superior derecha
		// Leemos los valores.
		long x = sc.nextLong();
		long y = sc.nextLong();

		// Terminamos cuando una de las dos coordenadas sea negativa
		while (x >= 0 && y >= 0) {
			// Como la esquina inferior izquierda está siempre en (0,0), el lado horizontal
			// vale x, y el lado vertical vale y. Simplemente doblamos y sumamos los números
			System.out.println(2 * x + 2 * y);
			// Leemos datos para el siguiente caso
			x = sc.nextInt();
			y = sc.nextInt();
		}
	}
}
