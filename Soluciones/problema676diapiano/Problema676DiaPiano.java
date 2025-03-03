

import java.util.Scanner;

public class Problema676DiaPiano {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int numCasos = scanner.nextInt();

		while (numCasos > 0) {
			int primerAnio = scanner.nextInt();
			int ultimoAnio = scanner.nextInt();

			int numBisiestos = cuentaBisiestos(primerAnio, ultimoAnio);
			int numNoBisiestos = (ultimoAnio - primerAnio + 1) - numBisiestos;

			System.out.printf("%s %s\n", numNoBisiestos, numBisiestos);
			
			numCasos--;
		}
	}

	private static int cuentaBisiestos(int primerAnio, int ultimoAnio) {
		int numBisiestos = 0;
		for (int anio = primerAnio; anio <= ultimoAnio; anio++) {
			if (esBisiesto(anio)) {
				numBisiestos++;
			}
		}
		return numBisiestos;
	}

	private static boolean esBisiesto(int anio) {
		return ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0)));
	}
}
