

import java.util.Scanner;

/**
 * Posible solución al problema 439 de Acepta el Reto.
 * Esta solución se basa en procesar cada caso, dividiendo las cadenas con el 
 * método split de la clase String. Una vez dividido e identificado en cada caso
 * qué valor hay que calcular, se realiza el cálculo y se genera la salida. 
 */
public class Problema439DesplazamientoTiempo {

	private static Scanner scanner = new Scanner(System.in);
	// Para probar el caso de uso de Acepta el Reto, descomentar esta línea y
	// comentar la anterior.
	// private static Scanner scanner = new Scanner("3\nD=32 T=4\nT=4 V=8\nV=8 D=32\n");

	public static void main(String[] args) {

		// Lectura de número de casos, y bucle para procesar los casos uno a uno
		int numCasos = Integer.parseInt(scanner.nextLine());
		while (numCasos-- > 0) {
			// Leemos y procesamos caso por caso
			procesarCaso(scanner.nextLine());
		}
	}

	private static void procesarCaso(String textoCaso) {
		// Separamos los datos del caso en dos
		String[] datos = textoCaso.split(" ");

		// Separamos cada dato en letra y número
		String[] primerDato = datos[0].split("=");
		String[] segundoDato = datos[1].split("=");

		// Inicializamos los tres datos necesarios con cero
		int velocidad = 0;
		int tiempo = 0;
		int distancia = 0;

		// Analizamos el primer dato, y según el tipo,
		// asignamos el valor a la variable adecuada
		if (primerDato[0].equals("V")) {
			velocidad = Integer.parseInt(primerDato[1]);
		} else if (primerDato[0].equals("T")) {
			tiempo = Integer.parseInt(primerDato[1]);
		} else { // Sólo queda D
			distancia = Integer.parseInt(primerDato[1]);
		}

		// Reperimos para el segundo dato
		if (segundoDato[0].equals("V")) {
			velocidad = Integer.parseInt(segundoDato[1]);
		} else if (segundoDato[0].equals("T")) {
			tiempo = Integer.parseInt(segundoDato[1]);
		} else { // Sólo queda D
			distancia = Integer.parseInt(segundoDato[1]);
		}

		// En este punto, tenemos que ver qué variable vale cero.
		// Ese será el dato que hay que calcular, y hay que generar
		// la salida adecuada para ese valor.
		if (velocidad == 0) {
			velocidad = distancia / tiempo;
			System.out.printf("V=%d\n", velocidad);
		} else if (tiempo == 0) {
			tiempo = distancia / velocidad;
			System.out.printf("T=%d\n", tiempo);
		} else {
			distancia = velocidad * tiempo;
			System.out.printf("D=%d\n", distancia);
		}
	}
}