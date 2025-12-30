import java.util.Scanner;

public class Problema825SueldoMaquinista {
    // Atributo estático, para usarlo desde cualquier método.
    // Debe estar descomentado para subir la solución a aceptaelreto.com
    private static Scanner sc = new Scanner(System.in);

    // Versión para probar casos de prueba del enunciado.
    // Solo para pruebas. No subir a aceptaelreto.com sin comentar esta línea.
    // private static Scanner sc = new Scanner("4\n10 10 5 0 0 0\n10 10 5 0 70 80\n10 10 5 5 70 80\n10 10 2 5 70 80\n");

    public static void main(String[] args) {
        // Leer número de casos, y repetir tantas veces como casos haya
        int numCasos = sc.nextInt();
        while (numCasos-- > 0) {
            // Procesar el caso
            procesarCaso();
        }
    }

    public static void procesarCaso() {
        // Leer datos del viaje
        long toneladas = sc.nextLong();
        long millas = sc.nextLong();

        // Leer datos de pago
        long pagoPorToneladaYMilla = sc.nextLong();

        // Leer datos de gastos
        long costePorMilla = sc.nextLong();
        long gastosMateriales = sc.nextLong();
        long gastosPersonal = sc.nextLong();

        // Calcular ingresos
        long ingresos = toneladas * millas * pagoPorToneladaYMilla;

        // Calcular gastos. Se multiplica por dos el coste por milla porque indicaban que daba
        // igual cargado o no, y que se aplicaba en ida y vuelta.
        long gastos = (2 * millas * costePorMilla) + gastosMateriales + gastosPersonal;

        // Calcular beneficios (o pérdidas)
        long balance = ingresos - gastos;

        // Mostrar el resultado
        System.out.println(balance);
    }
}

