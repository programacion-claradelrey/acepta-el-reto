# Los tres tipos de entrada en "Acepta el reto"
En acepta el reto los problemas se pueden clasificar según cómo indican el final de la entrada. Identificar correctamente el tipo de entrada es el primer punto para resolver el problema.

## Entrada que comienza con el número de casos de prueba
Es el caso más sencillo. La **primera línea** indica **cuántos casos** hay, y a continuación 
aparecen exactamente esos casos. Ejemplo típico de entrada:
```text
3
caso1
caso2
caso3
```
La forma para procesar este tipo de problemas es:
- Leer un entero "numCasos"
- Repetir "numCasos" veces lo necesario para leer el caso y procesarlo.

Ejemplo de programa Java para procesar este tipo de casos:
```java
import java.util.Scanner;
public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int numCasos = sc.nextInt(); // Alternativa: Integer.parseInt(sc.nextLine())
        sc.nextLine(); // limpiar salto de línea, solo si se ha usado nextInt() 

        for (int i = 0; i < casos; i++) {
            procesarCaso(); // Leerá de la entrada, y mostrará por la salida, lo necesario 
                            // para leer y procesar el caso. Pueden ser una o más de una 
                            // línea por caso.
        }
    }
}
```

## Entrada con caso especial que indica el final
No se indica cuántos casos hay. Se procesan casos **hasta que aparece un valor especial** que indica el **final de la entrada**, y que **normalmente no debe procesarse**. Ejemplo de este tipo de entrada:
```text
10
20
30
0
```
El 0 indica el final, y no se procesa.

La forma para procesar este tipo de problemas es:
- Leer casos en un bucle
- Parar cuando se detecta el valor especial

Ejemplo de programa Java para procesar este tipo de casos, cuando el caso es numérico (int):
```java
import java.util.Scanner;
public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int valorCaso;
        while ((valorCaso = sc.nextInt()) != 0) {
            procesarCaso(valorCaso);
        }
    }
}
```
Este tipo de entrada también puede darse en problemas que no trabajan con números. 
Ejemplo de entrada en un caso de este tipo:
```text
Caso número 1
Caso número 2
Caso número 3
FIN
```
Ejemplo de programa Java para procesar este tipo de casos, 
cuando el caso es String, y se identifica el final de entrada con "FIN":
```java
import java.util.Scanner;
public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String valorCaso;
        while (!(valorCaso = sc.nextLine()).equals("FIN")) {
            procesarCaso(valorCaso);
        }
    }
}
```
Este modelo para lectura de casos simples puede ser más elaborado con casos más complejos, con múltiples líneas por caso, o con varios valores numéricos de entrada en una misma línea. Cada problema necesita un estudio específico de la entrada.

## Entrada que se procesa hasta que no hay más datos (EOF)
No hay número de casos ni caso especial. Se procesan casos **hasta que se acaba la entrada** (EOF: End Of File).
Ejemplo de entrada en un caso de este tipo:
```text
caso1
caso2
caso3
```
Para procesar este tipo de problemas, hay que leer de la entrada hasta que no haya más datos disponibles. En Java, se suele hacer bien con Scanner, bien con BufferedReader.

Ejemplo de lectura con Scanner, suponiendo que cada caso necesita leer una línea de texto completa:
```java
import java.util.Scanner;
private static Scanner sc = new Scanner(System.in);
public class Main {
    public static void main(String[] args) {
        while (sc.hasNext()) {
            String linea = sc.nextLine();
            // Procesar el caso
            procesarCaso(linea);
        }
    }
}
```
En Scanner, el método hasNext() indica si hay pendientes datos en la entrada.

Ejemplo de lectura con BufferedReader, en las mismas condiciones:
```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String linea;
            while ((linea = br.readLine()) != null) {
                // Procesar el caso
                System.out.println(linea);
            }
        }
    }
}
```
En BufferedReader, el método "readLine" devuelve null cuando se acaban los datos.
Nota: en este código se está usando try with resources (la forma try(...){}). Esta sintaxis que simplifica en control / cierre de Streams está disponible desde la versión 7 de Java (JDK 1.7), por lo que debería funcionar bien en aceptaelreto.com.

## Algunos problemas de cada tipo en acepta el reto
### Entrada que empieza con número de casos
- 117 – Hello World
- 116 – Hola mundo
- 114 – Último dígito
### Entrada con caso final especial
- 100 – Constante mágica → termina cuando aparece 0
- 140 – Suma de dígitos → termina cuando el número es 0
- 155 – Perímetro de un rectángulo → final con 0 0
### Entrada hasta fin de fichero (EOF)
- 122 – Avituallamiento en las etapas del Tour
- 112 – Radares de tramo
- 149 – San Fermines