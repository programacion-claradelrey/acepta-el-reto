package es.claradelrey.aceptaelreto.resueltos.problema682metidoscajon;

import java.util.Scanner;

public class Problema682MetidosCajon {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		// Leemos el número de casos
		int numCasos = scanner.nextInt();

		// Procesamos caso
		while (numCasos > 0) {
			int numPatos = scanner.nextInt();
			System.out.printf("%d %d\n", numPatos, numPatos * 2);
			numCasos--;
		}
	}

}
