import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problema821OrdenandoRamales {
    // Atributo estático, para usarlo desde cualquier método.
    // Debe estar descomentado para subir la solución a aceptaelreto.com
    private static Scanner sc = new Scanner(System.in);

    // Versión para probar casos de prueba del enunciado.
    // Solo para pruebas. No subir a aceptaelreto.com sin comentar esta línea.
    // private static Scanner sc = new Scanner("3\nEdwardPease D 250\nGeorgeStephenson I 500\nGeorgeDixon I 250\n1\nGeorgeOverton D 1000\n0\n");

    public static void main(String[] args) {
        // Leer número de ramales, hasta que sean cero, y procesar el caso
        int numRamales;
        while ((numRamales = Integer.parseInt(sc.nextLine())) > 0) {
            procesarCaso(numRamales);
        }
    }

    private static void procesarCaso(int numRamales) {
        // Lista de ramales.
        List<Ramal> ramales = new ArrayList<>(numRamales);

        // Leer los ramales
        while (numRamales-- > 0) {
            String nombrePropietario = sc.next();
            String lado = sc.next();
            String distanciaAOrigen = sc.next();
            sc.nextLine(); // Como se usa next para leer, consumir el salto de línea final.
            // Añadir el ramal a la lista de ramales.
            ramales.add(new Ramal(nombrePropietario, Lado.valueOf(lado), Integer.parseInt(distanciaAOrigen)));
        }

        // Ordenar los ramales por el orden natural, que es el indicado en el problema.
        Collections.sort(ramales);

        // Mostrar los ramales
        for (Ramal ramal : ramales) {
            System.out.println(ramal.getPropietario());
        }

        // Mostrar separación de casos.
        System.out.println("---");
    }

    /**
     * Clase que representa un ramal en la vía.
     * Implementa Comparable, para poder ordenar los ramales según el criterio indicado en el problema, distancia
     * desde origen, y si están a la misma, primero el lado izquierdo.
     */
    private static class Ramal implements Comparable<Ramal> {
        private final String propietario;
        private final Lado lado;
        private final int distanciaAOrigen;

        public Ramal(String propietario, Lado lado, int distanciaAOrigen) {
            this.propietario = propietario;
            this.lado = lado;
            this.distanciaAOrigen = distanciaAOrigen;
        }

        public String getPropietario() {
            return propietario;
        }

        @Override
        public int compareTo(Ramal other) {
            int returnValue = Integer.compare(this.distanciaAOrigen, other.distanciaAOrigen);
            if (returnValue == 0) {
                // Misma distancia, primero el lado izquierdo.
                // Aunque en el problema se garantiza que no hay dos a la misma distancia
                // y en el mismo lado, se contempla la posibilidad en la implementación.
                if (this.lado == other.lado) return 0;
                return (this.lado == Lado.D) ? 1 : -1;
            }
            return returnValue;
        }
    }

    /**
     * Enumerado para los lados de la vía.
     */
    private enum Lado {
        D, I
    }
}
