

import java.util.Scanner;

public class Problema680CarreraSalmon01ConBucle {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int numCasos = Integer.parseInt(scanner.nextLine());

		while (numCasos > 0) {
			int objetivo = scanner.nextInt();
			int avanza = scanner.nextInt();
			int retrocede = scanner.nextInt();

			// Caso especial, con el primer "salto" llega
			if (objetivo <= avanza) {
				System.out.println(1);
			} else {
				int diferencia = avanza - retrocede;
				// No avanza lo suficiente en cada salto para llegar al destino
				if (diferencia <= 0) {
					System.out.println("IMPOSIBLE");
				} else {
					int numSaltos = 0;
					while (objetivo > 0) {
						numSaltos++;
						objetivo -= avanza;
						if (objetivo > 0) {
							objetivo += retrocede;
						}
					}
					System.out.println(numSaltos);
				}
			}

			numCasos--;
		}
	}
}
