
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Problema185Potitos {

	public static void main(String[] args) {
		// Casos de prueba del enunciado
		// Scanner scanner = new Scanner("3\n" + "SI: patata maiz tomate FIN\n" + "NO:
		// patata puerro guisantes pollo FIN\n"
		// + "SI: tomate zanahoria puerro pollo calabacin arroz FIN\n" + "2\n"
		// + "SI: tomate zanahoria pollo calabacin arroz FIN\n" + "NO: tomate ternera
		// puerro FIN\n" + "0\n");

		Scanner scanner = new Scanner(System.in);

		// Leemos el número de potitos
		int numPotitos;

		// Salimos cuando el número de potitos sea uno (o menos)
		while ((numPotitos = Integer.parseInt(scanner.nextLine())) > 0) {
			// Conjuntos para guardar los ingredientes que le gustan y los que no.
			// Usamos conjuntos porque así no guardamos ingredientes repetidos
			// Usamos TreeSet porque así se guardan ordenados.
			Set<String> ingredientesSi = new TreeSet<>();
			Set<String> ingredientesNo = new TreeSet<>();

			// Procesamos cada potito.
			for (int i = 0; i < numPotitos; i++) {
				// Leemos resultado y primer ingrediente
				String resultado = scanner.next();
				String ingrediente = scanner.next();
				// Mientras el ingrediente leído no sea "FIN"
				while (!ingrediente.equals("FIN")) {
					// Si le gustó el potito, añadimos el ingrediente al conjunto de los
					// ingredientes que le gustaron
					if (resultado.equals("SI:")) {
						ingredientesSi.add(ingrediente);
					}
					// Si no le gustó, lo añadimos al conjunto de los que no gustaron.
					if (resultado.equals("NO:")) {
						ingredientesNo.add(ingrediente);
					}
					// Leemos siguiente ingrediente
					ingrediente = scanner.next();
				}
				// Leemos el salto de línea que next() no procesa, para evitar errores.
				scanner.nextLine();
			}

			// Cuando tenemos todos los ingredientes, quitamos de los que no le gustaron los
			// que sabemos que le gustan. Podían estar en los que no le gustaron porque
			// estaban en un potito con otros que realmente no le gustan.
			ingredientesNo.removeAll(Arrays.asList(ingredientesSi.toArray()));
			// Mostramos los ingredientes, concatenándolos separados por espacios
			Object[] ingredientes = ingredientesNo.toArray();
			for (int i = 0; i < ingredientes.length; i++) {
				if (i > 0) {
					System.out.print(" ");
				}
				System.out.print(ingredientes[i]);
			}
			System.out.println();
		}
	}
}
