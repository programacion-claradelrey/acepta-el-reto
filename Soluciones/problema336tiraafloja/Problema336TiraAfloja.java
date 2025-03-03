import java.util.Scanner;

public class Problema336TiraAfloja {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// Procesamos múltiples casos de prueba hasta que no haya más entrada
		while (scanner.hasNext()) {
			int numAlumnos = scanner.nextInt(); // Leer el número de alumnos en la fila
			int[] pesoAlumnos = new int[numAlumnos]; // Array para almacenar los pesos de los alumnos
			int pesoTotalAlumnos = 0; // Suma total del peso de todos los alumnos

			// Leer los pesos de los alumnos y calcular el peso total
			for (int i = 0; i < numAlumnos; i++) {
				pesoAlumnos[i] = scanner.nextInt();
				pesoTotalAlumnos += pesoAlumnos[i];
			}

			// Procesar el caso actual
			procesarCaso(pesoAlumnos, pesoTotalAlumnos);
		}
	}

	// Método para procesar cada caso de prueba
	private static void procesarCaso(int[] pesoAlumnos, int pesoTotalAlumnos) {
		int pesoIzquierda = 0; // Peso acumulado del equipo izquierdo
		int diferenciaMinima = pesoTotalAlumnos; // Diferencia mínima entre equipos
		int cantidadAlumnosIzquierdaDiferenciaMinima = 0; // Alumnos en la izquierda con mínima diferencia
		int pesoIzquierdaDiferenciaMinima = 0; // Peso en la izquierda con mínima diferencia

		// Iteramos sobre la fila dividiendo en dos equipos
		for (int i = 0; i < pesoAlumnos.length; i++) {
			pesoIzquierda += pesoAlumnos[i]; // Agregar alumno al equipo izquierdo
			int pesoDerecha = pesoTotalAlumnos - pesoIzquierda; // Calcular peso derecho directamente
			int diferencia = Math.abs(pesoIzquierda - pesoDerecha); // Calcular diferencia entre equipos

			// Si encontramos otra posición con la misma diferencia mínima, terminamos de
			// inmediato, porque no se puede saber con certeza la posición.
			if (diferencia == diferenciaMinima) {
				System.out.println("NO JUEGAN");
				return;
			}

			// Si encontramos una diferencia menor, actualizamos los valores
			if (diferencia < diferenciaMinima) {
				diferenciaMinima = diferencia;
				cantidadAlumnosIzquierdaDiferenciaMinima = i + 1; // Número de alumnos en el equipo izquierdo
				pesoIzquierdaDiferenciaMinima = pesoIzquierda; // Peso del equipo izquierdo
			}
		}

		// Imprimir la mejor solución encontrada
		System.out.printf("%d %d %d\n", cantidadAlumnosIzquierdaDiferenciaMinima, pesoIzquierdaDiferenciaMinima,
				pesoTotalAlumnos - pesoIzquierdaDiferenciaMinima);
	}
}
