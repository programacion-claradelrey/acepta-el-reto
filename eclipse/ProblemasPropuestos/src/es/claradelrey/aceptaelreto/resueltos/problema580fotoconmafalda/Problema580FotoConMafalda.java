package es.claradelrey.aceptaelreto.resueltos.problema580fotoconmafalda;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.aceptaelreto.com/problem/statement.php?id=580
 */
public class Problema580FotoConMafalda {
	// Al usar enumerados el programa es más rápido. La comparación de cadenas es
	// mucho más lenta que la de enumerados.
	enum Personaje {
		MAFALDA, FELIPE, MANOLITO, SUSANITA, MIGUELITO, LIBERTAD, GUILLE
	}

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			int numPersonas;
			while ((numPersonas = scanner.nextInt()) != 0) {

				EnumSet<Personaje> foto = EnumSet.noneOf(Personaje.class);
				List<Personaje> esperando = new LinkedList<>();

				int numFotos = 0;
				while (numPersonas > 0) {
					// Es posible que se pueda hacer la foto porque hayamos colocado a personas
					// esperando, tras haber hecho una foto. Por eso sólo cogemos la siguiente
					// persona que está en la cola si no puedo hacer foto.
					if (!puedoHacerFoto(foto)) {
						// Leemos personaje y lo convertimos a enumerado
						Personaje personaje = Personaje.valueOf(scanner.next().toUpperCase());
						numPersonas--;
						// Si no está en la foto, lo añado a la foto. Si ya está, lo dejamos en la cola
						// de espera.
						if (!foto.contains(personaje)) {
							foto.add(personaje);
						} else {
							esperando.add(personaje);
						}
					}

					// Mirar si ya puedo hacer la foto.
					if (puedoHacerFoto(foto)) {
						numFotos++;
						foto.clear();
						// Tras hacer una foto, antes de tomar más gente de la cola, se permite a los
						// que habían dejado pasar a otros colocarse en la foto
						colocarEsperando(foto, esperando);
					}

				}
				// Cuando hemos terminado con la cola de personas, los que están en la foto y no
				// pueden hacerla todavía, más los que dejaron pasar a otros y no se han podido
				// colocar, son los que no pueden hacerse la foto.
				int personasSinFoto = foto.size() + esperando.size();
				System.out.printf("%d %d\n", numFotos, personasSinFoto);
			}
		}
	}

	private static void colocarEsperando(EnumSet<Personaje> foto, List<Personaje> esperando) {
		// Recorremos todos los elementos que están esperando. Si no está ya en la foto,
		// se añade, y se elimina del conjunto de personas esperando.
		// Se termina el bucle cuando hemos acabado de recorrer las personas esperando o
		// cuando hemos añadido los necesarios para hacer una foto.
		Iterator<Personaje> iterador = esperando.iterator();
		while (iterador.hasNext() && !puedoHacerFoto(foto)) {
			Personaje personaje = iterador.next();
			if (!foto.contains(personaje)) {
				foto.add(personaje);
				iterador.remove();
			}
		}
	}

	// Para hacer una foto tiene que haber al menos 3 personas, y una tiene que
	// querer ocupar la posición de Mafalda
	private static boolean puedoHacerFoto(EnumSet<Personaje> foto) {
		return foto.contains(Personaje.MAFALDA) && foto.size() >= 3;
	}

}
