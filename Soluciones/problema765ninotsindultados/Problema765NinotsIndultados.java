import java.util.*;

public class Problema765NinotsIndultados {

    private static Scanner scanner = new Scanner(System.in);

    // private static Scanner scanner = new Scanner("2\nQUARTEXTRAMURS
    // najordana\n5\ncondealtea GUANYARDINES\nantigadecampanar QUARTEXTRAMURS
    // GUANYARDINES\n0");

    public static void main(String[] args) {

        int numVotos;
        while ((numVotos = Integer.parseInt(scanner.nextLine())) > 0) {
            Map<String, Integer> votosInfantiles = new HashMap<>();
            Map<String, Integer> votosAdultos = new HashMap<>();
            while (numVotos-- > 0) {
                String ninot = scanner.next();
                if (ninot.equals(ninot.toLowerCase())) {
                    if (!votosInfantiles.containsKey(ninot)) {
                        votosInfantiles.put(ninot, 1);
                    } else {
                        votosInfantiles.put(ninot, votosInfantiles.get(ninot) + 1);
                    }
                } else {
                    if (!votosAdultos.containsKey(ninot)) {
                        votosAdultos.put(ninot, 1);
                    } else {
                        votosAdultos.put(ninot, votosAdultos.get(ninot) + 1);
                    }
                }
            }
            // La última lectura con next() deja un salto de línea sin leer,
            // hay que leerlo para que no falle el parseInt del inicio del bucle.
            scanner.nextLine();

            // Trazas para probar
            // System.out.println(votosInfantiles);
            // System.out.println(votosAdultos);

            System.out.printf("%s %s\n", obtenerGanador(votosInfantiles, true), obtenerGanador(votosAdultos, false));

        }

    }

    private static String obtenerGanador(Map<String, Integer> votos, boolean lowerCase) {
        // Convertimos en conjunto de Map.EntrySet en una lista para poder ordenarlos.
        List<Map.Entry<String, Integer>> recuento = new ArrayList<>(votos.entrySet());
        // Ordenamos la lista por frecuencia, las más altas primero
        // El List.sort no funciona en 1.7. Usamos Collections.sort
        // Comparator.reverseOrder y Map.Entry.comparingByValue tampoco funcionan en
        // 1.7.
        // Usamos un comparador en clase anónima
        Collections.sort(recuento, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // Invertimos el signo para que sea descendente
                return -Integer.compare(o1.getValue(), o2.getValue());
            }
        });
        // Si hay más de uno, hay que comprobar si hay empate
        if (recuento.size() > 1) {
            // Hay más de uno. Comprobamos si hay empate
            if ((int) recuento.get(0).getValue() == recuento.get(1).getValue()) {
                return lowerCase ? "empate" : "EMPATE";
            }
        }

        // En este punto, como solo hay uno, o no hay empate, el primero de la lista es
        // el ganador.
        return recuento.get(0).getKey();
    }
}