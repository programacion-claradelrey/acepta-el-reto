package es.claradelrey.aceptaelreto.problema683termoclastismo;

import java.util.Scanner;

public class Problema683Termoclastismo {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int numMuestras;
		while ((numMuestras = scanner.nextInt()) != 0) {
			procesarCaso(numMuestras);
		}
	}

	private static void procesarCaso(int numMuestras) {
		int menor, primeraPosicionMenor, ultimaPosicionMenor;
		int mayor, primeraPosicionMayor, ultimaPosicionMayor;

		// Asumimos que el primero es el mayor y el menor a la vez, y ya hemos procesado
		// una muestra.
		menor = mayor = scanner.nextInt();
		primeraPosicionMenor = 0;
		ultimaPosicionMenor = 0;
		primeraPosicionMayor = 0;
		ultimaPosicionMayor = 0;

		for (int posicion = 1; posicion < numMuestras; posicion++) {
			int temperatura = scanner.nextInt();

			if (temperatura < menor) {
				menor = temperatura;
				primeraPosicionMenor = posicion;
				ultimaPosicionMenor = posicion;
			} else if (temperatura == menor) {
				ultimaPosicionMenor = posicion;
			}

			if (temperatura > mayor) {
				mayor = temperatura;
				primeraPosicionMayor = posicion;
				ultimaPosicionMayor = posicion;
			} else if (temperatura == mayor) {
				ultimaPosicionMenor = posicion;
			}
		}

		int menorDistancia = Math.abs(primeraPosicionMenor - primeraPosicionMayor);
		menorDistancia = Math.min(menorDistancia, Math.abs(primeraPosicionMenor - ultimaPosicionMayor));
		menorDistancia = Math.min(menorDistancia, Math.abs(ultimaPosicionMenor - primeraPosicionMayor));
		menorDistancia = Math.min(menorDistancia, Math.abs(ultimaPosicionMenor - ultimaPosicionMayor));

		System.out.printf("%s %s %s\n", menor, mayor, menorDistancia);
	}
}
