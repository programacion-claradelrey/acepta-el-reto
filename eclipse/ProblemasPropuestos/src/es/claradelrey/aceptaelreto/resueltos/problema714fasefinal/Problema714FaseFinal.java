package es.claradelrey.aceptaelreto.resueltos.problema714fasefinal;

import java.util.Scanner;

public class Problema714FaseFinal {

	private static Scanner scanner = new Scanner(System.in);
//	private static Scanner scanner = new Scanner(
//			"16\n" + "Switzerland Spain Netherlands SouthAfrica Japan Norway Sweden UnitedStates\n"
//					+ "Australia Denmark France Morocco England Nigeria Colombia Jamaica\n"
//					+ "1 5 2 0 3 1 5 4 2 0 4 0 4 2 1 0 2 1 1 2 7 6 2 1 2 1 1 3 1 0\n" + "0\n" + "");

	public static void main(String[] args) {

		int numeroEquipos;
		while ((numeroEquipos = Integer.parseInt(scanner.nextLine())) != 0) {
			procesarCaso(numeroEquipos);
		}
	}

	private static void procesarCaso(int numeroEquipos) {
		String[] equipos = new String[numeroEquipos];
		// Leemos equipos
		for (int i = 0; i < equipos.length; i++) {
			equipos[i] = scanner.next();
		}
		// Leemos el \n que el next() no procesa
		scanner.nextLine();

		procesarCaso(equipos);

		// Leemos el \n que los nextInt no leen
		scanner.nextLine();
	}

	private static void procesarCaso(String[] equipos) {
		if (equipos.length == 1) {
			// Sólo queda un equipo. Es el ganador
			System.out.println(equipos[0]);
			return;
		}
		// Hay mñás de 1 equipo. Hay que ver los resultados.
		// Leemos los goles de los equipos
		int[] goles = new int[equipos.length];
		for (int i = 0; i < goles.length; i++) {
			goles[i] = scanner.nextInt();
		}

		// Creamos array para quedarnos con los ganadores.
		String[] clasificados = new String[equipos.length / 2];

		// Miramos resultados y nos quedamos con los ganadores
		// Vamos de 2 en dos, porque cada dos equipos es un partido
		for (int i = 0; i < equipos.length; i += 2) {
			if (goles[i] > goles[i + 1]) {
				clasificados[i / 2] = equipos[i];
			} else {
				clasificados[i / 2] = equipos[i + 1];
			}
		}

		// Con los clasificados llamamos recursivamente para obtener los clasificados de
		// la siguiente ronda, hasta que quede sólo uno.
		procesarCaso(clasificados);
	}
}
