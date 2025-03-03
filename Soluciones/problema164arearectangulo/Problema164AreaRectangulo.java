

import java.util.Scanner;

/**
 * Problema https://www.aceptaelreto.com/problem/statement.php?id=164 Se
 * recomienda hacer antes el 155, que es similar pero algo más fácil.
 */
public class Problema164AreaRectangulo {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// Variables para leer coordenadas de las dos
		// Leemos los valores.
		long x1 = sc.nextLong();
		long y1 = sc.nextLong();
		long x2 = sc.nextLong();
		long y2 = sc.nextLong();

		// Terminamos cuando la segunda esquina está por debajo o a la izquierda de la
		// primera
		while (x2 >= x1 && y2 >= y1) {
			// El lado horizontal se calcula con la resta x2-x1
			// El lado vertical se calcula con la resta y2-y1
			// Luego simplemente multiplicamos las restas
			System.out.println((x2 - x1) * (y2 - y1));
			// Leemos datos para el siguiente caso
			x1 = sc.nextLong();
			y1 = sc.nextLong();
			x2 = sc.nextLong();
			y2 = sc.nextLong();
		}
	}
}
