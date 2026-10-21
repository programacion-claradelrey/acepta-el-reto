# Cómo probar tus programas antes de enviarlos al juez

> *"¿Puedo probar mi programa con la entrada de ejemplo? No es que puedas, ¡es que debes!"* — FAQ de Acepta el reto

El juez **no te dice en qué caso falla** tu programa: solo te da un veredicto (AC, WA, PE…). Y sus casos de prueba son **secretos** y mucho más numerosos y retorcidos que el ejemplo del enunciado. Por eso, cuanto mejor pruebes en tu ordenador, menos envíos fallidos tendrás y menos tiempo perderás. En un concurso como ProgramaMe, además, los envíos incorrectos **suman tiempo de penalización**.

Esta guía va de lo imprescindible (puntos 1 a 3) a lo más avanzado (puntos 5 y 6).

## 1. Prepara el programa como lo va a recibir el juez
Antes de probar nada, asegúrate de que tu programa cumple las reglas del juez:

- **Lee de la entrada estándar** (`System.in`) y **escribe en la salida estándar** (`System.out`). Nada de ficheros.
- **No escribas mensajes "amables"** del tipo `"Introduce un número: "` o `"El resultado es: "`. El juez compara tu salida con la esperada carácter a carácter, y cualquier texto de más es un error.
- **La clase debe ser `public`** y tener el método `public static void main(String[] args)`.
- **Quita la línea `package ...;`** que añaden algunos IDE (IntelliJ, Eclipse) al principio del fichero.
- **No uses tildes ni eñes** en el nombre de la clase (`Problema100Año` → `Problema100Anio`).
- **Todo en un único fichero**: si necesitas clases auxiliares, defínelas dentro, como clases `static`.
- **Usa solo la biblioteca estándar de Java.** Además, el juez usa una versión antigua de Java (la [FAQ](https://aceptaelreto.com/doc/faq.php) indica OpenJDK 1.7), así que **evita lambdas, `stream()`, `var`, `record`** y otras novedades posteriores. Si quieres asegurarte en tu ordenador, compila con la versión más antigua que admita tu JDK (por ejemplo `javac --release 8 Main.java`) y no uses lambdas ni streams.

## 2. Prueba con el ejemplo del enunciado... usando ficheros
Escribir la entrada a mano en la consola cada vez es lento y da lugar a errores. Lo cómodo es tener la entrada en un fichero y **redirigirla** al programa.

### 2.1. Consigue los ficheros del ejemplo
En la página de cada problema, junto al enunciado, hay un enlace **"Descargar el ejemplo"** que baja un `.zip` con la entrada y la salida esperada del ejemplo. Descomprímelo en la carpeta donde está tu programa. (Si lo prefieres, copia el ejemplo del enunciado en dos ficheros de texto.)

En esta guía llamaremos a esos ficheros `entrada.txt` (la entrada de ejemplo) y `esperada.txt` (la salida que debería dar tu programa). Usa los nombres que tengan en tu caso.

### 2.2. Ejecuta redirigiendo la entrada
Desde un terminal, en la carpeta del programa:

```bash
javac Main.java
java Main < entrada.txt
```

El símbolo `<` hace que el programa lea de `entrada.txt` como si lo estuvieras tecleando. Funciona igual en Linux, macOS y en el **Símbolo del sistema (cmd)** de Windows.

> ⚠️ En **PowerShell** el símbolo `<` no funciona. Usa `Get-Content entrada.txt | java Main`, o abre un `cmd`.

> 💡 Con Java 11 o posterior puedes ejecutar un fichero sin compilarlo antes: `java Main.java < entrada.txt`.

### 2.3. Si prefieres hacerlo desde el IDE
- **IntelliJ IDEA**: *Run → Edit Configurations…* → *Modify options* → **Redirect input from** → elige `entrada.txt`.
- **Eclipse**: *Run → Run Configurations…* → pestaña **Common** → en *Standard Input and Output* marca **Input File** y elige `entrada.txt`.
- **VS Code**: lo más sencillo es usar el terminal integrado con los comandos del apartado anterior.

## 3. Compara tu salida con la esperada, carácter a carácter
"A mí me sale lo mismo" mirando la pantalla **no basta**: un espacio de más al final de una línea o un salto de línea que falta no se ven, y provocan un **PE** (error de presentación). Deja que lo compare el ordenador:

**Linux / macOS:**
```bash
java Main < entrada.txt > mia.txt
diff mia.txt esperada.txt
```
Si `diff` no muestra nada, las salidas son idénticas. Si muestra líneas, son las diferencias (`<` es tu salida, `>` la esperada).

**Windows (cmd):**
```bat
java Main < entrada.txt > mia.txt
fc mia.txt esperada.txt
```
Si todo va bien, `fc` dice que *no se han encontrado diferencias*.

> 💡 La **última línea** de tu salida también debe terminar con salto de línea. Si escribes con `System.out.println(...)` ya lo tienes.

## 4. Inventa tus propios casos de prueba
El ejemplo del enunciado suele ser pequeño y "amable". Los casos del juez, no. Antes de enviar, crea un fichero con casos pensados para romper tu programa:

- **Valores límite.** Lee bien los rangos del enunciado y prueba el mínimo y el máximo: `0`, `1`, el valor más grande permitido… Si el enunciado dice *"entre 1 y 10⁹"*, prueba `1` y `1000000000`.
- **Desbordamientos.** Un `int` llega solo hasta 2.147.483.647 (≈ 2·10⁹). Si al sumar o multiplicar puedes pasarte, usa `long`. Ejemplo clásico: multiplicar dos números de hasta 10⁹.
- **Casos especiales que menciona el enunciado.** Suelen estar ahí por algo: "si todos los dígitos son iguales…", "si hay empate…", "si no hay solución, escribe…".
- **Casos "raros" pero válidos.** Una lista de un solo elemento, todos los elementos iguales, una palabra de una letra, el número de casos igual a 0…
- **El final de la entrada.** Comprueba que tu programa para justo donde debe: que **no procesa** el caso final especial, y que en los problemas EOF no espera datos de más (revisa [los tres tipos de entrada](01-tipos-de-problemas.md)).
- **Decimales.** Si el problema pide números con decimales, comprueba el número de decimales y el redondeo. Y cuidado: en un ordenador configurado en español, `String.format("%.2f", x)` y `printf` escriben **coma** (`3,14`) en lugar de punto. Para obtener siempre `3.14`, indica el idioma: `String.format(java.util.Locale.US, "%.2f", x)`. Lo mismo al leer decimales con `Scanner`: `sc.useLocale(java.util.Locale.US)`.

Guarda estos casos en ficheros (`prueba1.txt`, `prueba2.txt`…) para poder repetirlos cada vez que cambies el programa.

## 5. Comprueba el rendimiento con entradas grandes
Cada problema indica un **tiempo máximo** y una **memoria máxima**. Si tu programa es correcto pero lento, recibirás **TLE**.

### 5.1. Estima antes de programar
Un ordenador hace del orden de **10⁸ operaciones sencillas por segundo**. Mira el tamaño máximo de la entrada (`n`) y piensa cuántas operaciones hace tu algoritmo:

| Tamaño máximo de `n` | Algoritmos que suelen entrar en tiempo |
|---|---|
| hasta ~10 | Probar todas las combinaciones, `n!` |
| hasta ~1.000 | Dos bucles anidados, `n²` |
| hasta ~100.000 – 1.000.000 | Un bucle, o ordenar: `n`, `n·log n` |
| hasta ~10⁹ o más | Fórmula directa o `log n` (no se puede ni recorrer) |

### 5.2. Genera una entrada grande y mide
Escribe un pequeño programa que genere un fichero con el caso más grande posible. Por ejemplo, para un problema con hasta 300.000 números entre 1 y 70 por caso:

```java
import java.util.Random;

public class Generador {
    public static void main(String[] args) {
        Random azar = new Random();
        int n = 300000;
        StringBuilder sb = new StringBuilder();
        sb.append(n).append('\n');
        for (int i = 0; i < n; i++) {
            sb.append(1 + azar.nextInt(70));
            sb.append(i < n - 1 ? ' ' : '\n');
        }
        System.out.print(sb);
    }
}
```

```bash
java Generador > grande.txt
time java Main < grande.txt > /dev/null      # Linux / macOS
```
En Windows (PowerShell): `Measure-Command { cmd /c "java Main < grande.txt > NUL" }`.

Si tarda bastante más que el límite del enunciado, el juez te dará TLE (aunque los ordenadores no son iguales, sirve como orientación).

### 5.3. Trucos para que Java vaya más rápido
- **Lee con `BufferedReader`** en lugar de `Scanner` cuando la entrada sea muy grande. `Scanner` es cómodo pero lento.
- **Escribe con `StringBuilder`** (o `PrintWriter`) y haz un único `System.out.print` al final, en lugar de miles de `System.out.println`.
- **No concatenes `String` dentro de bucles** (`s = s + ...`): usa `StringBuilder`.
- Si el algoritmo es demasiado lento (por ejemplo, `n²` con `n = 300.000`), ningún truco de lectura lo salvará: hay que **cambiar de algoritmo**.

## 6. (Avanzado) Compara con una solución "de fuerza bruta"
Cuando tienes una solución rápida pero no estás seguro de que sea correcta, escribe otra **lenta pero obviamente correcta** (probando todas las posibilidades) y compara las dos con muchas entradas pequeñas generadas al azar. Si en algún caso dan resultados distintos, ese caso te muestra el error. Es una técnica muy usada en programación competitiva.

## ✅ Lista de comprobación antes de pulsar "Enviar"
- [ ] He leído entero el apartado **Entrada** y sé de qué tipo es (número de casos, caso final, EOF).
- [ ] Sin `package`, clase `public`, sin tildes en el nombre, todo en un fichero.
- [ ] Sin mensajes para el usuario ni `println` de depuración olvidados.
- [ ] Con el ejemplo del enunciado, `diff`/`fc` no muestra diferencias.
- [ ] He probado valores límite y casos especiales.
- [ ] He pensado si necesito `long` en lugar de `int`.
- [ ] Si la entrada puede ser grande, he comprobado que va rápido.

Cuando todo esté en orden: [cómo enviar un problema y entender el veredicto](04-enviar-y-veredictos.md).
