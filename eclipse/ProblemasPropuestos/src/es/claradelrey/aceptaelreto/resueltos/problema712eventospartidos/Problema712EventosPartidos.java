package es.claradelrey.aceptaelreto.resueltos.problema712eventospartidos;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Problema712EventosPartidos {
	private static Scanner scanner = new Scanner(System.in);
//	private static Scanner scanner = new Scanner("10\n" + "300 Fuera de juego de Russo\n" + "1749 Gol de Olga Carmona\n"
//			+ "2241 Disparo a puerta de Alba Redondo\n" + "2791 Sale Alessia Ruso\n" + "2791 Entra Lauren James\n"
//			+ "3076 Saque de esquina\n" + "3333 Tarjeta amarilla para Lauren Hemp\n" + "5433 Sale Mariona Caldentey\n"
//			+ "5433 Entra Alexia Putellas\n" + "6327 Fin del partido\n" + "3\n" + "1\n" + "5\n" + "7");

	public static void main(String[] args) {

		while (scanner.hasNext()) {
			// Leemos el número de eventos
			int numEventos = Integer.parseInt(scanner.nextLine());
			// Creamos un mapa para contar los eventos en cada instante
			TreeMap<Integer, Integer> eventosPorInstante = new TreeMap<>();
			// Leemos los eventos y los contamos en el mapa
			for (int i = 0; i < numEventos; i++) {
				int instante = scanner.nextInt();
				String evento = scanner.nextLine(); // Se descarta, no hace falta
				if (eventosPorInstante.containsKey(instante)) {
					eventosPorInstante.put(instante, eventosPorInstante.get(instante) + 1);
				} else {
					eventosPorInstante.put(instante, 1);
				}
			}
			// Creamos un array de objetos Instante, para poder manejarlos mejor con técnica
			// de ventana deslizante. Podrían usarse arrays independientes para los
			// instantes y el número de eventos por instante
			Instante[] instantes = new Instante[eventosPorInstante.size()];
			int i = 0;
			for (Map.Entry<Integer, Integer> entry : eventosPorInstante.entrySet()) {
				Integer instante = entry.getKey();
				Integer numEventosInstante = entry.getValue();
				instantes[i] = new Instante(instante, numEventosInstante);
				i++;
			}
			// Leemos el número de consultas a realizar
			int numConsultas = Integer.parseInt(scanner.nextLine());

			// Leemos las consultas
			while (numConsultas > 0) {
				int numeroEventosConsulta = Integer.parseInt(scanner.nextLine());
				buscarMenorIntervalo(instantes, numeroEventosConsulta);
				numConsultas--;
			}
			// Mostramos el separador de casos.
			System.out.println("---");
		}
	}

	private static void buscarMenorIntervalo(Instante[] instantes, int numEventosBuscado) {

//		for (Instante instante : instantes) {
//			System.out.printf("%d(%d) ", instante.getInstante(), instante.getNumEventos());
//		}
//		System.out.println();

		// Vamos a procesar esto con ventana deslizante, para evitar un posible TLE

		// Inicializamos la primera ventana, de duración un instante, el primero del
		// partido
		int inicioVentanaActual = 0; // La primera ventana empieza en el primer instante
		int finVentanaActual = 0; // Y acaba también el primer instante.
		int eventosVentanaActual = instantes[0].getNumEventos(); // Tendrá los eventos del primer instante.
		int duracionVentanaActual = 0; // Y su duración es cero, porque sólo es un instante.

		// Inicializamos las variables para el mejor caso encontrado.
		int duracionMejorVentana = Integer.MAX_VALUE; // Para que la primera ventana encontrada sea de menor duración

		// Estas variables se inicializan para evitar que Java se queje por variables
		// que pueden no haberse inicializado.
		int inicioMejorVentana = -1;
		int finMejorVentana = -1;
		int eventosMejorVentana = -1;

		// Usamos un flag para el control del fin del bucle, porque las condiciones de
		// parada son variadas, y es más fácil que hacerlo con una condición compleja en
		// el while
		boolean terminado = false;

		// Comenzamos a procesar ventanas.
		while (!terminado) {

			// Descomenta este código si quieres ver cada ventana, duración y número de
			// eventos evaluados.
			// System.out.printf("\t%04d - %04d - %04d - %04d\n",
			// instantes[inicioVentanaActual].getInstante(),
			// instantes[finVentanaActual].getInstante(), duracionVentanaActual,
			// eventosVentanaActual);

			// Comprobación de ventana actual, comparándola con el mejor caso encontrado
			// hasta ahora.
			if (eventosVentanaActual >= numEventosBuscado) {
				boolean esMejorVentana = false;
				// Tenemos suficientes eventos. Tenemos que quedarnos con la ventana más corta
				if (duracionVentanaActual < duracionMejorVentana) {
					// Menor duración de ventana, nos quedamos con la nueva, más corta
					// Inicialmente duracionMejorVentana es Integer.MAX_VALUE, por lo que la primera
					// ventana que se encuentre será más corta y será la solución provisional.
					esMejorVentana = true;
				} else if (duracionVentanaActual == duracionMejorVentana) {
					// Igual duración, nos quedamos con la nueva sólo si tiene más eventos
					esMejorVentana = eventosVentanaActual > eventosMejorVentana;
				}

				// Si hemos encontrado una opción mejor nos quedamos con los valores
				if (esMejorVentana) {
					inicioMejorVentana = inicioVentanaActual;
					finMejorVentana = finVentanaActual;
					eventosMejorVentana = eventosVentanaActual;
					duracionMejorVentana = duracionVentanaActual;
				}

			}

			// Cambiamos de ventana. El cambio se puede hacer aumentando la ventana (hacia
			// la derecha) o reduciéndola (desde la izquierda). Sobre la marcha hay que
			// comprobar si hemos llegado al fin del proceso.
			if (eventosVentanaActual < numEventosBuscado) {
				// Necesitamos más eventos, así que deberíamos añadir instantes (por la derecha
				// de la ventana actual), pero:
				// - Si el fin de la ventana actual ha llegado al final del array hemos
				// terminado, porque no podemos ampliar la ventana a la derecha, sólo reducirla
				// por la izquierda, y al reducirla nunca podremos tener el número de eventos
				// buscado.
				// - Si no hemos llegado al final ampliamos la ventana hacia la derecha.
				if (finVentanaActual == instantes.length - 1) {
					terminado = true;
				} else {
					// Ampliamos la ventana
					finVentanaActual++;
					// Sumamos los eventos del instante añadido a los eventos de la ventana
					eventosVentanaActual += instantes[finVentanaActual].getNumEventos();
				}
			} else {
				// Ya tenemos suficientes eventos. Vamos a intentar reducir la ventana por la
				// izquierda para ver si podemos tener una más pequeña con suficientes eventos,
				// pero:
				// - Si el inicio de la ventana actual ha llegado al final del array hemos
				// terminado, porque no podemos reducir la ventana por la izquierda, ni tampoco
				// ampliarla por la derecha.
				// - Si no hemos llegado al final reducimos la ventana por la izquierda, sólo si
				// el inicio y fin de la ventana no son la misma posición. Si el inicio y el fin
				// de la ventana actual son el mismo, no podemos reducir por la izquierda, hay
				// que ampliar por la derecha, para en la siguiente iteración reducir por la
				// izquierda

				if (inicioVentanaActual == instantes.length - 1) {
					terminado = true;
				} else {
					if (inicioVentanaActual < finVentanaActual) {
						// Podemos reducir la ventana.
						// Restamos los eventos del instante que vamos a quitar
						eventosVentanaActual -= instantes[inicioVentanaActual].getNumEventos();
						// Reducimos la ventana
						inicioVentanaActual++;
					} else {
						// Ampliamos la ventana
						finVentanaActual++;
						// Sumamos los eventos del instante añadido a los eventos de la ventana
						eventosVentanaActual += instantes[finVentanaActual].getNumEventos();
					}
				}
			}
			// Recalculamos la duración de la ventana 
			duracionVentanaActual = instantes[finVentanaActual].getInstante()
					- instantes[inicioVentanaActual].getInstante();
		}
		// A la salida del bucle, tendremos la mejor ventana
		System.out.printf("%d %d %d\n", instantes[inicioMejorVentana].getInstante(),
				instantes[finMejorVentana].getInstante(), eventosMejorVentana);

	}

	private static class Instante {
		private int instante;
		private int numEventos;

		public Instante(int instante, int numEventos) {
			this.instante = instante;
			this.numEventos = numEventos;
		}

		public int getInstante() {
			return instante;
		}

		public int getNumEventos() {
			return numEventos;
		}
	}
}
