

import java.util.Scanner;

public class Problema677CuadradoCinco {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		// Leemos el número de casos
		int numCasos = Integer.parseInt(scanner.nextLine());

		while (numCasos > 0) {
			// Leemos el número como cadena. Si lo intentamos procesar como un número
			// podemos tener problemas de desbordamiento.
			String numero = scanner.nextLine();
			int longitud = numero.length();
			// El caso de longitud 1 se trata de forma independiente.
			if (longitud > 1) {
				// Extraemos todos los dígitos excepto el 5 final.
				String parteInicial = numero.substring(0, numero.length() - 1);
				// Convertimos lo extraido a Long. Con int puede dar desbordamiento
				long numeroParteInicial = Long.valueOf(parteInicial);
				// Trabajamos con cadenas para evitar que al multiplicar y luego añadir un
				// dígito nos salgamos del rango de Long
				System.out.printf("%s%s\n", numeroParteInicial * (numeroParteInicial + 1), "25");
			} else {
				System.out.println("25");
			}
			numCasos--;
		}
	}

}
