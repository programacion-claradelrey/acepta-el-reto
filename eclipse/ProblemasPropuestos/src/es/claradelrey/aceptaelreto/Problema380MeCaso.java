package entrenamiento;

import java.util.Scanner;
/* ¡Me caso! 
 * Problema https://www.aceptaelreto.com/problem/statement.php?id=380
 */
public class Problema380MeCaso {

	public static void main(String[] Args) {
	    long numGastos, total, gasto;
	    Scanner sc = new Scanner(System.in);
	    numGastos = sc.nextInt();
	    while(numGastos != 0) {	        
	        total = 0;
	        // Tan simple como ir sumando todos los gastos...
	        while(numGastos > 0) {
	        	gasto = sc.nextInt();
	        	numGastos--;
	            total += gasto;
	        }
	        System.out.println(total);
	        numGastos = sc.nextInt();
	    }
	    sc.close();
	}

}
