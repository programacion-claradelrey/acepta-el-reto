import java.util.Scanner;

public class Problema823ViajandoSiglo19 {
    // Atributo estático, para usarlo desde cualquier método.
    // Debe estar descomentado para subir la solución a aceptaelreto.com
    private static Scanner sc = new Scanner(System.in);

    // Versión para probar casos de prueba del enunciado.
    // Solo para pruebas. No subir a aceptaelreto.com sin comentar esta línea.
    // private static Scanner sc = new Scanner("6\n1 0 0 0\n0 1 0 0\n0 0 1 0\n0 0 0 1\n1 1 1 1\n10 10 10 10\n");

    public static void main(String[] args) {
        // Leer número de casos, y repetir tantas veces como casos haya
        int numCasos = sc.nextInt();
        while (numCasos-- > 0) {
            // Procesar el caso
            procesarCaso();
        }
    }

    private static void procesarCaso() {
        // Variable para acumular el importe total, en peniques.
        long peniques = 0;

        // Leer usuarios de distinto tipo, y multiplicar por el precio de su billete en peniques
        // Normal - Dentro
        peniques += sc.nextLong() * 12;
        // Normal - Fuera
        peniques += sc.nextLong() * 9;
        // Más cómodo - Dentro
        peniques += sc.nextLong() * 18;
        // Más cómodo - Fuera
        peniques += sc.nextLong() * 12;

        // Usando aritmética modular (división entera y resto de división entera),
        // convertir el total de peniques en libras, chelines y peniques

        // Dividir por 12 (un chelín = 12 peniques) para pasar de peniques a chelines "completos".
        // El resto es los peniques que "sobran".
        long chelines = peniques / 12;
        peniques = peniques % 12;
        // Dividir por 20 (una libra = 20 chelines) para pasar de chelines a libras "completas".
        // El resto es los chelines que "sobran".
        long libras = chelines / 20;
        chelines = chelines % 20;

        // Mostrar salida.
        System.out.printf("%d %d %d\n", libras, chelines, peniques);
    }
}
