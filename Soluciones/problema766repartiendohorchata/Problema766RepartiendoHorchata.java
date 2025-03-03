import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Problema766RepartiendoHorchata {

    private static Scanner scanner = new Scanner(System.in);

    // private static Scanner scanner = new Scanner("10 2\n6 4\n4 7\n15 3\n5 8\n6
    // 10\n5 5\n8 2\n5 5\n10 10\n0 0");
    // private static Scanner scanner = new Scanner("15 3\n5 8\n6 10\n5 5\n0 0");

    public static void main(String[] args) {

        long cantidadHorchata = scanner.nextInt();
        long personasCola = scanner.nextInt();
        while (cantidadHorchata > 0 && personasCola > 0) {
            LinkedList<Persona> personas = new LinkedList<>();
            for (int i = 0; i < personasCola; i++) {
                int trabajo = scanner.nextInt();
                int cantidadTrabajo = scanner.nextInt();
                personas.add(new Persona(trabajo, cantidadTrabajo));
            }
            Collections.sort(personas);
            boolean seAcaboLaHorchata = false;
            while (!personas.isEmpty() && !seAcaboLaHorchata) {
                Persona persona = personas.peekFirst();
                if (cantidadHorchata >= persona.tamanioBotella) {
                    cantidadHorchata -= persona.tamanioBotella;
                    personas.removeFirst();
                } else {
                    seAcaboLaHorchata = true;
                }
            }
            long personasAtendidas = personasCola - personas.size();
            System.out.printf("%d %d\n", personasAtendidas, cantidadHorchata);
            cantidadHorchata = scanner.nextInt();
            personasCola = scanner.nextInt();
        }

    }

    private static class Persona implements Comparable<Persona> {
        private int trabajo;
        private int tamanioBotella;

        public Persona(int trabajo, int tamanioBotella) {
            this.trabajo = trabajo;
            this.tamanioBotella = tamanioBotella;
        }

        @Override
        public int compareTo(Persona other) {
            int result = -Integer.compare(this.trabajo, other.trabajo);
            if (result == 0) {
                result = Integer.compare(this.tamanioBotella, other.tamanioBotella);
            }
            return result;
        }
    }
}