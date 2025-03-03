
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.aceptaelreto.com/problem/statement.php?id=579
 */
public class Problema579FelipeTareas {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// Variable para leer número de tareas.
		int numTareas;

		// Terminamos cuando una el número de tareas es cero
		while ((numTareas = sc.nextInt()) != 0) {
			// Inicializamos el arrayList con el tamaño esperado. Es más eficiente.
			List<Tarea> tareas = new ArrayList<>(numTareas);
			for (int i = 0; i < numTareas; i++) {
				int prioridad = sc.nextInt();
				int duracion = sc.nextInt();
				tareas.add(new Tarea(prioridad, duracion));
			}

			// Ordenamos las tareas
			Collections.sort(tareas);

			// Mostramos las tareas
			for (Tarea tarea : tareas) {
				System.out.printf("%d %d\n", tarea.getPrioridad(), tarea.getDuracion());
			}

			// Mostramos guiones de cierre
			System.out.println("---");
		}
	}

	// Clase auxiliar para la tarea. Implementa Comparable<T> para poder ordenar
	// fácilmente. Se podría haber usado una clase Comparator<Tarea> en lugar de
	// implementar la interfaz.
	private static class Tarea implements Comparable<Tarea> {
		private int prioridad;
		private int duracion;

		public Tarea(int prioridad, int duracion) {
			this.prioridad = prioridad;
			this.duracion = duracion;
		}

		public int getPrioridad() {
			return prioridad;
		}

		public int getDuracion() {
			return duracion;
		}

		@Override
		public int compareTo(Tarea o) {
			// Comparamos prioridad, primero la de más prioridad. Para invertir el orden
			// natural (primero el menor) hay dos opciones. La primera, la que usamos aquí,
			// que es comparar el segundo con el primero, invirtiendo el orden. La segunda
			// opción es comparar el primero con el segundo e invertir el resultado,
			// quedando: int comparacion = -Integer.compare(this.prioridad, o.prioridad)
			int comparacion = Integer.compare(o.prioridad, this.prioridad);
			if (comparacion == 0) {
				// Si tienen la misma prioridad, primero la más corta.
				comparacion = Integer.compare(this.duracion, o.duracion);
			}

			// Devolvemos el valor de la comparación.
			return comparacion;
		}

	}
}
