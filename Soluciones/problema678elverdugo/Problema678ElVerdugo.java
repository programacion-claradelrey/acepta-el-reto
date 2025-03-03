

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problema678ElVerdugo {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		String palabraBuscada;
		while (!(palabraBuscada = scanner.nextLine()).equals(".")) {
			// Convertimos la palabra en un conjunto para ser más eficientes
			Set<Character> buscadas = new HashSet<>();
			for (Character letraBuscada : palabraBuscada.toCharArray()) {
				buscadas.add(letraBuscada);
			}
			int numLetrasBuscadas = buscadas.size();

			// Conjuntos para guardar las acertadas y las falladas.
			Set<Character> acertadas = new HashSet<>();
			Set<Character> falladas = new HashSet<>();

			// Leemos las letras usadas como array, para poder iterar.
			char[] letras = scanner.nextLine().toCharArray();

			int numLetras = letras.length;
			int numLetraActual = 0;
			while ((numLetraActual < numLetras) && (acertadas.size() < numLetrasBuscadas) && (falladas.size() < 7)) {
				char letraActual = letras[numLetraActual];
				if (buscadas.contains(letraActual)) {
					acertadas.add(letraActual);
				} else {
					falladas.add(letraActual);
				}
				numLetraActual++;
			}
			if (falladas.size() >= 7) {
				System.out.println("AHORCADO");
			} else if (acertadas.size() >= buscadas.size()) {
				System.out.println("SALVADO");
			}else {
				System.out.println("COLGANDO");
			}
		}
	}

}
