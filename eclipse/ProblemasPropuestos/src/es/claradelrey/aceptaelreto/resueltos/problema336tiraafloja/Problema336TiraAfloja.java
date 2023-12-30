package es.claradelrey.aceptaelreto.resueltos.problema336tiraafloja;

import java.util.Scanner;

public class Problema336TiraAfloja {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		while (scanner.hasNext()) {
			int numAlumnos = scanner.nextInt();
			int[] pesoAlumnos = new int[numAlumnos];
			int pesoTotalAlumnos = 0;
			for (int i = 0; i < pesoAlumnos.length; i++) {
				int pesoUnAlumno = scanner.nextInt();
				pesoAlumnos[i] = pesoUnAlumno;
				pesoTotalAlumnos += pesoUnAlumno;
			}

			// Procesamos el caso
			procesarCaso(pesoAlumnos, pesoTotalAlumnos);
		}

	}

	private static void procesarCaso(int[] pesoAlumnos, int pesoTotalAlumnos) {
		int pesoIzquierda = 0;
		int pesoDerecha = pesoTotalAlumnos;
		int diferenciaMinima = pesoTotalAlumnos;
		int cantidadAlumnosIzquierdaDiferenciaMinima = 0;
		int pesoIzquierdaDiferenciaMinima = 0;

		for (int i = 0; i < pesoAlumnos.length; i++) {
			pesoIzquierda += pesoAlumnos[i];
			pesoDerecha -= pesoAlumnos[i];
			int diferencia = Math.abs(pesoIzquierda - pesoDerecha);
			if (diferencia == diferenciaMinima) {
				System.out.println("NO JUEGAN");
				return;
			}
			if (diferencia < diferenciaMinima) {
				diferenciaMinima = diferencia;
				cantidadAlumnosIzquierdaDiferenciaMinima = i + 1;
				pesoIzquierdaDiferenciaMinima = pesoIzquierda;
			}
		}
		System.out.printf("%d %d %d\n", cantidadAlumnosIzquierdaDiferenciaMinima, pesoIzquierdaDiferenciaMinima,
				pesoTotalAlumnos - pesoIzquierdaDiferenciaMinima);

	}

}
