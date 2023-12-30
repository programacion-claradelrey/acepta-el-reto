package es.claradelrey.aceptaelreto.resueltos.problema713fasedegrupos;

import java.util.Arrays;
import java.util.Scanner;

public class Problema713FaseDeGrupos {

	private static Scanner scanner = new Scanner(System.in);
//	private static Scanner scanner = new Scanner("4 2\n" + "1 2 3 0\n" + "3 4 0 5\n" + "4 2 2 0\n" + "1 3 5 0\n"
//			+ "4 1 4 0\n" + "2 3 1 3\n" + "3 1\n" + "1 2 3 0\n" + "1 3 3 0\n" + "2 3 0 0\n" + "");
//	private static Scanner scanner = new Scanner(
//			"4 2\n" + "1 2 3 0\n" + "3 4 0 5\n" + "4 2 2 0\n" + "1 3 5 0\n" + "4 1 4 0\n" + "2 3 1 3\n");

	public static void main(String[] args) {

		while (scanner.hasNext()) {
			// Leemos número de equipos y de clasificados, y calculamos el númeto de
			// partidos.
			int numEquipos = scanner.nextInt();
			int numClasificados = scanner.nextInt();
			int numPartidos = numEquipos * (numEquipos - 1) / 2;

			// Array para almacenar los equipos. Cada equipo se almacena en la posción
			// nªequipo-1
			Equipo[] equipos = new Equipo[numEquipos];
			// Llenamos el array de equipos con equipos sin partidos y sin puntos
			for (int i = 0; i < equipos.length; i++) {
				equipos[i] = new Equipo(i + 1);
			}

			// Leemos partidos y actualizamos equipos
			while (numPartidos > 0) {
				// Leemos datos de equipos
				int numEquipoLocal = scanner.nextInt();
				int numEquipoVisitante = scanner.nextInt();
				// Leemos resultado
				int golesLocal = scanner.nextInt();
				int golesVisitante = scanner.nextInt();

				// Calculamos puntos para local y para visitante.
				int puntosLocal = (golesLocal > golesVisitante) ? 3 : ((golesLocal < golesVisitante) ? 0 : 1);
				int puntosVisitante = (golesLocal > golesVisitante) ? 0 : ((golesLocal < golesVisitante) ? 3 : 1);

				// Actualizamos objeto del equipo local en el array
				equipos[numEquipoLocal - 1].actualizarEstadisticas(golesLocal, golesVisitante, puntosLocal);
				// Actualizamos objeto del equipo visitante en el array
				equipos[numEquipoVisitante - 1].actualizarEstadisticas(golesVisitante, golesLocal, puntosVisitante);
				numPartidos--;
			}

			// Ordenamos array de equipos.
			Arrays.sort(equipos);

			boolean hayEmpate = false;
			// Si sólo hay un equipo, no tiene sentido buscar empates.
			if (numEquipos > 1) {
				// Buscamos equipos que estén empatados. Buscamos empates entre:
				// - Los equipos que estén clasificados, y el primer no clasificado.
				// - Por si el número de clasificados es igual al número de equipos, tenemos una
				// condición de seguridad (i < numEquipos -1), para evitar salirnos del array
				for (int i = 0; (i < numClasificados) && (i < numEquipos - 1) && !hayEmpate; i++) {
					if (equipos[i].compareTo(equipos[i + 1]) == 0) {
						hayEmpate = true;
					}
				}
			}

			// Si hay empate lo mostramos
			if (hayEmpate) {
				System.out.println("EMPATE");
			} else {
				// No hay empate, mostramos los primeros clasificados, separados por espacio
				for (int i = 0; i < numClasificados; i++) {
					if (i > 0) {
						System.out.print(" ");
					}
					System.out.print(equipos[i].getNumEquipo());
				}
				System.out.println();
			}
		}
	}

	private static void mostrarClasificacion(Equipo[] equipos) {
		for (Equipo equipo : equipos) {
			System.out.println(equipo);
		}

	}

	/**
	 * Clase para abstraer los resultados de un equipo para poder ordenarlos
	 */
	private static class Equipo implements Comparable<Equipo> {
		private int numEquipo;
		private int golesFavor;
		private int golesContra;
		private int puntos;

		public Equipo(int numEquipo) {
			this.numEquipo = numEquipo;
		}

		public int getNumEquipo() {
			return numEquipo;
		}

		public int getGolesFavor() {
			return golesFavor;
		}

		public void setGolesFavor(int golesFavor) {
			this.golesFavor = golesFavor;
		}

		public int getGolesContra() {
			return golesContra;
		}

		public void setGolesContra(int golesContra) {
			this.golesContra = golesContra;
		}

		public int getPuntos() {
			return puntos;
		}

		public void setPuntos(int puntos) {
			this.puntos = puntos;
		}

		public int getDifGoles() {
			return this.golesFavor - this.golesContra;
		}

		public void actualizarEstadisticas(int golesFavor, int golesContra, int puntosObtenidos) {
			this.golesFavor += golesFavor;
			this.golesContra += golesContra;
			this.puntos += puntosObtenidos;

		}

		@Override
		public int compareTo(Equipo other) {
			// Comparamos primero los puntos, de modo que esté primero el que tenga más
			// puntos. Por eso invertimos el resultado de Integer.compare(...)
			int compareValue = -Integer.compare(this.puntos, other.puntos);
			// Si los puntos eran distintos, no tenemos que seguir comparando.
			if (compareValue != 0) {
				return compareValue;
			}
			// Etán empatados a puntos, pasamos a comparar diferencia de goles. Otra vez,
			// invertimos porque queremos que los equipos con más diferencia de goles estén
			// antes en la clasificación
			compareValue = -Integer.compare(this.getDifGoles(), other.getDifGoles());
			// Si la diferencia de goles era distinta, no tenemos que seguir comparando.
			if (compareValue != 0) {
				return compareValue;
			}
			// Como último criterio, goles a favor. Primero el que más tenga.
			return -Integer.compare(this.golesFavor, other.golesFavor);
		}

		@Override
		public String toString() {
			return String.format("%2d %2d %2d %2d %2d", this.numEquipo, this.puntos, this.golesFavor, this.golesContra,
					this.getDifGoles());
		}
	}
}
