package es.claradelrey.aceptaelreto;

/**
Entrada
5 1 25
5 1 5
10 1 100
2 5 20
5 0 25
0 0 0
Salida
31 1
6 1
111 1
RUINA
25 25
Chicles de regalo

 Problema https://www.aceptaelreto.com/problem/statement.php?id=121
 */

import java.util.Scanner;

public class Problema121ChiclesDeRegalo {
	/* Chicles de regalo */
	public static void main(String[] Args) {
		int necesitan, dan, tiene, total, packs, resto;
		Scanner sc = new Scanner(System.in);
		necesitan = sc.nextInt();
		dan = sc.nextInt();
		tiene = sc.nextInt();
		while (necesitan != 0 || dan != 0  || tiene != 0) {
			if (necesitan == 0 && dan == 0 && tiene == 0)
				break;
			// Segun las condiciones del programa vamos por el camino correspondiente
			if (dan >= necesitan && tiene >= necesitan) {
				System.out.println("RUINA");

			} else if (dan == 0) { /* no nos dan ningun chicle... */
				System.out.println(tiene + " " + tiene);
			} else {
				total = tiene;
				while (tiene >= necesitan) {
					packs = tiene / necesitan;
					total += packs * dan;
					resto = tiene % necesitan;
					tiene = packs + resto;
				}
				System.out.println(total + " " + tiene);

			}
			necesitan = sc.nextInt();
			dan = sc.nextInt();
			tiene = sc.nextInt();
		}
		sc.close();
	}
}
