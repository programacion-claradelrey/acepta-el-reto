# Los tres tipos de entrada en "Acepta el reto"
En acepta el reto los problemas se pueden clasificar según cómo indican el final de la entrada. Identificar correctamente el tipo de entrada es el primer punto para resolver el problema.

| Tipo | Cómo sabes cuándo parar | Frases típicas en el apartado **Entrada** del enunciado |
|---|---|---|
| [Número de casos](#1-entrada-que-comienza-con-el-número-de-casos-de-prueba) | La primera línea dice cuántos casos hay | *"La entrada comienza con el número de casos de prueba"*, *"La primera línea contiene el número de casos"* |
| [Caso especial final](#2-entrada-con-caso-especial-que-indica-el-final) | Aparece un valor especial (0, -1, `FIN`…) que **no se procesa** | *"La entrada termina con…"*, *"…que no debe procesarse"*, *"el último caso, que marca el final, contiene…"* |
| [Hasta fin de entrada (EOF)](#3-entrada-que-se-procesa-hasta-que-no-hay-más-datos-eof) | Se acaban los datos | *"La entrada consta de un número indeterminado de casos"* (sin decir cómo termina), *"una serie de casos de prueba"* |

> 💡 **Lee siempre el apartado *Entrada* entero**, incluida la última frase. Muchos errores (WA, RTE, TLE) vienen de haber leído mal cómo termina la entrada.

En todos los ejemplos de esta guía, `procesarCaso(...)` representa el método que **tú** escribes para leer lo que falte del caso, calcularlo y escribir su resultado.

## 1. Entrada que comienza con el número de casos de prueba
Es el caso más sencillo. La **primera línea** indica **cuántos casos** hay, y a continuación
aparecen exactamente esos casos. Ejemplo típico de entrada:
```text
3
caso1
caso2
caso3
```
La forma para procesar este tipo de problemas es:
- Leer un entero `numCasos`
- Repetir `numCasos` veces lo necesario para leer el caso y procesarlo.

Ejemplo de programa Java para procesar este tipo de casos:
```java
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int numCasos = sc.nextInt(); // Alternativa: Integer.parseInt(sc.nextLine())
        sc.nextLine();               // limpiar el salto de línea, solo si se ha usado nextInt()
                                     // y luego se van a leer líneas con nextLine()

        for (int i = 0; i < numCasos; i++) {
            procesarCaso(); // Leerá de la entrada, y mostrará por la salida, lo necesario
                            // para leer y procesar el caso. Pueden ser una o más de una
                            // línea por caso.
        }
    }

    private static void procesarCaso() {
        String linea = sc.nextLine();
        // ... calcular y escribir el resultado del caso
    }
}
```

> ⚠️ **Cuidado al mezclar `nextInt()` y `nextLine()`.** `nextInt()` lee el número pero **deja el salto de línea** en la entrada. Si justo después llamas a `nextLine()`, obtendrás una cadena vacía. Por eso, tras leer `numCasos` con `nextInt()`, hay que "limpiar" con un `sc.nextLine()` antes de leer líneas completas. Si en el caso solo vas a leer números con `nextInt()`, no hace falta.

## 2. Entrada con caso especial que indica el final
No se indica cuántos casos hay. Se procesan casos **hasta que aparece un valor especial** (a veces se le llama *centinela*) que indica el **final de la entrada**, y que **normalmente no debe procesarse**. Ejemplo de este tipo de entrada:
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

    private static void procesarCaso(int valorCaso) {
        // ... calcular y escribir el resultado del caso
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

    private static void procesarCaso(String valorCaso) {
        // ... calcular y escribir el resultado del caso
    }
}
```

### El caso final no siempre es un 0
Fíjate bien en **qué** marca el final, porque cambia de un problema a otro:
- Un número concreto: `0`, `-1`…
- **Cualquier** número negativo (problema 140): la condición debe ser `numero >= 0`, no `numero != -1`.
- **Varios** valores a la vez, por ejemplo `0 0 0` (problema 112): hay que leer **todos** los valores del caso y comprobar la condición sobre todos ellos.
- Una condición más elaborada, por ejemplo "cuando alguna coordenada es negativa" (problema 155).

Cuando el caso tiene varios valores, un patrón cómodo es un bucle "infinito" que lee el caso completo y sale con `break` al detectar el final:
```java
while (true) {
    int distancia = sc.nextInt();
    int velocidadMaxima = sc.nextInt();
    int segundos = sc.nextInt();
    if (distancia == 0 && velocidadMaxima == 0 && segundos == 0) {
        break; // caso final: no se procesa
    }
    procesarCaso(distancia, velocidadMaxima, segundos);
}
```

Este modelo para lectura de casos simples puede ser más elaborado con casos más complejos, con múltiples líneas por caso, o con varios valores numéricos de entrada en una misma línea. Cada problema necesita un estudio específico de la entrada.

## 3. Entrada que se procesa hasta que no hay más datos (EOF)
No hay número de casos ni caso especial. Se procesan casos **hasta que se acaba la entrada** (EOF: End Of File).
Ejemplo de entrada en un caso de este tipo:
```text
caso1
caso2
caso3
```
Para procesar este tipo de problemas, hay que leer de la entrada hasta que no haya más datos disponibles. En Java, se suele hacer bien con `Scanner`, bien con `BufferedReader`.

Ejemplo de lectura con Scanner, suponiendo que cada caso necesita leer una línea de texto completa:
```java
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
            procesarCaso(linea);
        }
    }

    private static void procesarCaso(String linea) {
        // ... calcular y escribir el resultado del caso
    }
}
```
En Scanner, los métodos `hasNext...()` indican si quedan datos pendientes en la entrada. Usa el que corresponda con lo que vas a leer a continuación:
- `hasNextLine()` si vas a leer con `nextLine()`.
- `hasNextInt()` (o `hasNextLong()`, `hasNext()`…) si vas a leer con `nextInt()` (o `nextLong()`, `next()`…).

Por ejemplo, si cada caso empieza por un número (como en el problema 149, donde el primer número de cada línea indica cuántos valores vienen detrás):
```java
while (sc.hasNextInt()) {
    int numToros = sc.nextInt();
    int velocidadMaxima = 0;
    for (int i = 0; i < numToros; i++) {
        velocidadMaxima = Math.max(velocidadMaxima, sc.nextInt());
    }
    System.out.println(velocidadMaxima);
}
```

Ejemplo de lectura con BufferedReader, leyendo una línea completa por caso:
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Procesar el caso. Aquí, como ejemplo, simplemente se repite la línea.
                System.out.println(linea);
            }
        }
    }
}
```
En BufferedReader, el método `readLine()` devuelve `null` cuando se acaban los datos.
Nota: en este código se está usando *try with resources* (la forma `try(...){}`). Esta sintaxis, que simplifica el control y cierre de Streams, está disponible desde la versión 7 de Java (JDK 1.7), por lo que debería funcionar bien en aceptaelreto.com.

> 💡 `BufferedReader` es **bastante más rápido** que `Scanner`. En problemas con entradas muy grandes (cientos de miles de números) puede ser la diferencia entre un AC y un TLE. Más detalles en [probar antes de enviar](03-probar-antes-de-enviar.md#5-comprueba-el-rendimiento-con-entradas-grandes).

> 🧪 **¿Cómo pruebo a mano un problema EOF?** Si escribes la entrada en la consola, tienes que indicar tú el final: **Ctrl+D** en Linux/macOS, **Ctrl+Z y después Intro** en Windows. Es mucho más cómodo probar con ficheros: lo explicamos en [probar antes de enviar](03-probar-antes-de-enviar.md).

## Algunos problemas de cada tipo en acepta el reto
Cuando hay solución en este repositorio, se enlaza.

### Entrada que empieza con número de casos
- [595 – ¿En qué volumen?](https://aceptaelreto.com/problem/statement.php?id=595) → el problema de la guía "Tu primer problema" de la web.
- [117 – La fiesta aburrida](https://aceptaelreto.com/problem/statement.php?id=117) → cuidado con `nextInt()` + `nextLine()`.
- [114 – Último dígito del factorial](https://aceptaelreto.com/problem/statement.php?id=114) → [solución](../Soluciones/problema114ultimodigitofactorial/Problema114UltimoDigitoFactorial.java)
- [100 – Constante de Kaprekar](https://aceptaelreto.com/problem/statement.php?id=100) → [solución](../Soluciones/problema100kaprekar/Problema100Kaprekar.java)

### Entrada con caso final especial
- [140 – Suma de dígitos](https://aceptaelreto.com/problem/statement.php?id=140) → termina con un número **negativo**.
- [155 – Perímetro de un rectángulo](https://aceptaelreto.com/problem/statement.php?id=155) → termina cuando alguna coordenada es **negativa**. [Solución](../Soluciones/problema155perimetrorectangulo/Problema155PerimetroRectangulo.java)
- [112 – Radares de tramo](https://aceptaelreto.com/problem/statement.php?id=112) → termina con `0 0 0`.
- [122 – Avituallamiento en las etapas ciclistas](https://aceptaelreto.com/problem/statement.php?id=122) → cada caso termina con `-1`, y la entrada termina con una línea que solo tiene `-1`.

### Entrada hasta fin de fichero (EOF)
- [149 – San Fermines](https://aceptaelreto.com/problem/statement.php?id=149) → un caso por línea; el primer número indica cuántos vienen detrás.
- [188 – Encadenando palabras](https://aceptaelreto.com/problem/statement.php?id=188) → un caso por línea, con palabras. [Solución](../Soluciones/problema188encadenandopalabras/Problema188EncadenandoPalabras.java)
- [336 – Tira y afloja](https://aceptaelreto.com/problem/statement.php?id=336) → **dos líneas por caso** y entradas muy grandes. [Solución](../Soluciones/problema336tiraafloja/Problema336TiraAfloja.java)
