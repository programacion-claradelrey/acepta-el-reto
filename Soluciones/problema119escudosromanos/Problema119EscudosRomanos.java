
/*
Entrada de ejemplo
35
20
10
0
Salida de ejemplo
71
44
26

Escudos romanos
Problema https://www.aceptaelreto.com/problem/statement.php?id=119
 */

import java.util.Scanner;

public class Problema119EscudosRomanos {
	public static void main(String args[]) {
		Scanner entrada = new Scanner(System.in);
		int nRomanos, nEscudos, cuadradoMin, raizExacta;

		while ((nRomanos = entrada.nextInt()) != 0) {
			nEscudos = 0;
			while (nRomanos != 0) { // Distribuimos los escudos hasta que nos quedemos sin romanos
				raizExacta = (int) Math.sqrt(nRomanos);
				cuadradoMin = (int) Math.pow(raizExacta, 2);
				nEscudos += (raizExacta * 4) + cuadradoMin;
				nRomanos -= cuadradoMin; // Resto de romanos en otras formaciones
			}
			System.out.println(nEscudos);
		}
		entrada.close();
	}
}
