

import java.util.Scanner;

public class Problema618BuscandoNivel {
	public static void main(String[] args) {
		// Casos de prueba en enunciado
		// Scanner scanner = new Scanner("5 10 20 40 7 3\n3\n1 2\n2 5\n4 1\n0\n");
		Scanner scanner = new Scanner(System.in);

		// Leemos número de niveles
		int numNiveles;
		// Salimos cuando el número de niveles sea cero (o menor que cero)
		while ((numNiveles = scanner.nextInt()) > 0) {
			// Arrays para guardar las posiciones de los juegos.
			// Como la entrada se refiere al primer nivel como 1, y no cero, dimensionamos
			// los arrays con tamaño numNiveles+1 para no tener que restar 1 cuando queramos
			// acceder a los datos.
			// Hay dos arrays porque uno guarda la posición de inicio y otro la de fin
			long[] inicio = new long[numNiveles + 1];
			long[] fin = new long[numNiveles + 1];

			// Empezamos a guardar juegos desde la posición 0 de la cinta
			long inicioActual = 0;
			for (int i = 1; i <= numNiveles; i++) {
				// Leemos duración del juego "i"
				int duracion = scanner.nextInt();
				// Guardamos inicio
				inicio[i] = inicioActual;
				// Calculamos y guardamos inicio
				fin[i] = inicioActual + duracion;
				// El inicio del siguiente será el fin del actual
				inicioActual = inicioActual + duracion;
			}

			// Leemos número de subconsultas
			int numConsultas = scanner.nextInt();
			for (int i = 0; i < numConsultas; i++) {
				int nivelActual = scanner.nextInt();
				int nivelDestino = scanner.nextInt();
				// Para cada subconsulta calculamos la diferencia entre el fin del nivel actual
				// y el inicio del nivel destino
				long distancia = inicio[nivelDestino] - fin[nivelActual];
				System.out.println(distancia);
			}

			// Separamos los casos con el delimitador solicitado.
			System.out.println("---");
		}
	}
}
