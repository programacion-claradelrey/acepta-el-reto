package es.claradelrey.aceptaelreto.resueltos.problema710plazasmundial;

import java.util.Scanner;

public class Problema710PlazasMundial {

	private static Scanner scanner = new Scanner(System.in);
//	private static Scanner scanner = new Scanner("4\n"
//			+ "32 11 6 4 4 3 1\n"
//			+ "32 1 3 4 4 6 11\n"
//			+ "128 1 1 1 1 1 1\n"
//			+ "4 1 1 1 1 0 0\n"
//			+ "");

	public static void main(String[] args) {

		int numCasos = Integer.parseInt(scanner.nextLine());

		while (numCasos > 0) {
			procesarCaso();
			numCasos--;
		}
	}

	private static void procesarCaso() {
		// Leemos primero el total de plazas
		int totalPlazas = scanner.nextInt();

		// Leemos ahora las seis reservas, sumándolas
		int plazasReservadas = scanner.nextInt();
		plazasReservadas += scanner.nextInt();
		plazasReservadas += scanner.nextInt();
		plazasReservadas += scanner.nextInt();
		plazasReservadas += scanner.nextInt();
		plazasReservadas += scanner.nextInt();

		// La resta del total menos las reservadas es la solución al problema
		System.out.println(totalPlazas - plazasReservadas);
	}

}
