package es.claradelrey.aceptaelreto.resueltos.problema545ahorrandofuerzas;

import java.util.Scanner;

public class Problema545AhorrandoFuerzas {
	private static Scanner scanner = new Scanner(System.in);
	// private static Scanner scanner = new Scanner("10 2\n" + "0 5 -10 2\n" + "10
	// 2\n" + "0 2 2 10\n" + "10 1\n" + "0 3");

	public static void main(String[] args) {

		while (scanner.hasNext()) {
			int distancia = scanner.nextInt();
			int numVehiculos = scanner.nextInt();
			double tiempoMinimo = Double.MAX_VALUE;
			while (numVehiculos > 0) {
				int cuandoPasa = scanner.nextInt();
				int velocidad = scanner.nextInt();
				// Si pasa antes de que Marty llegue no puede agarrarse, así que sólo tenemos en
				// cuenta los que llegan a la vez o después de que marty llegue.
				if (cuandoPasa >= 0) {
					tiempoMinimo = Math.min(tiempoMinimo, ((double) distancia / velocidad) + cuandoPasa);
				}
				numVehiculos--;
			}
			System.out.println((int) tiempoMinimo);

		}

	}
}
