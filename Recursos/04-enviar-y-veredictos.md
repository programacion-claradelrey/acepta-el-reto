# Cómo enviar un problema y entender el veredicto

Has [probado tu programa](03-probar-antes-de-enviar.md) y crees que está bien. Ahora toca que lo compruebe el juez.

## Qué hace el juez con tu programa
1. **Compila** tu código.
2. Lo **ejecuta** varias veces, pasándole por la entrada estándar sus casos de prueba (que son **secretos**).
3. **Compara** tu salida con la salida correcta, carácter a carácter.
4. Vigila que no te pases del **tiempo** ni de la **memoria** máximos del problema, y que no hagas operaciones prohibidas (abrir ficheros, conexiones de red, hilos…).

El resultado de todo esto es un **veredicto**: un código de dos o tres letras.

## Cómo enviar
1. **Inicia sesión** (botón **Login**). Sin sesión iniciada no se puede enviar. Si aún no tienes cuenta, mira [cómo registrarse](00-registro.md).
2. **Busca el problema.** Desde **Problemas** puedes navegar por volúmenes: el volumen 1 tiene los problemas del 100 al 199, el 2 del 200 al 299, etc. También puedes ir directamente a la dirección `https://aceptaelreto.com/problem/statement.php?id=NÚMERO` (por ejemplo, `id=595`).
3. En la página del problema, pulsa la pestaña **Enviar** (al lado de *Enunciado*, *Estadísticas* y *Créditos*).
4. Comprueba que el **lenguaje** seleccionado es **Java**. Si eliges otro, tendrás un error de compilación.
5. Elige entre **pegar el código** en el cuadro de texto o **subir el fichero** `.java`.
6. Opcionalmente, rellena el **comentario**. El juez no lo usa y nadie más lo ve; sirve para que tú distingas tus envíos (por ejemplo, *"versión con BufferedReader"*).
7. Pulsa **Enviar**.

> ⚠️ Antes de pegar el código, repasa la lista del apartado 1 de [probar antes de enviar](03-probar-antes-de-enviar.md#1-prepara-el-programa-como-lo-va-a-recibir-el-juez): **sin `package`, clase `public`, sin mensajes para el usuario**.

### "¡Dame un respiro!"
El juez limita cuántos envíos puedes hacer seguidos: como máximo **3 en el último minuto, 4 en los últimos 2, 6 en los últimos 5 y 8 en los últimos 8**. Si te pasas, verás el mensaje *"¡Dame un respiro!"* y tendrás que esperar un poco. Si te ocurre, es buena señal de que estás enviando "a ver si cuela" en lugar de probar en tu ordenador.

## Cómo ver el resultado
Tras enviar, verás tu envío en la **lista de envíos**, con su veredicto, el tiempo y la memoria que ha usado.

- Mientras el juez lo procesa, el veredicto será **IQ** (*In Queue*, en cola). Espera unos segundos y recarga la página.
- En la lista, el **identificador del envío** es un enlace: desde ahí puedes ver de nuevo el código que enviaste. Muy útil para recuperar una versión anterior.
- Tu código **no lo pueden ver otros usuarios**.

## Los veredictos y qué hacer con cada uno

| Veredicto | Significado | Causas típicas | Qué hacer |
|---|---|---|---|
| 🟢 **AC** *Accepted* | **¡Aceptado!** Ha pasado todos los casos de prueba. | — | ¡Enhorabuena! Pasa al siguiente. Si quieres, [aporta tu solución al repositorio](../normas-aportaciones.md). |
| 🟡 **PE** *Presentation Error* | La respuesta es correcta, pero el **formato** no: espacios, tabuladores o saltos de línea. | Espacio de más al final de la línea; falta o sobra un salto de línea; separar con dos espacios en vez de uno; línea en blanco entre casos que no se pide. | Estás muy cerca. Compara con `diff`/`fc` (no a ojo) y revisa el formato exacto de la **Salida** del enunciado. |
| 🔴 **WA** *Wrong Answer* | El programa termina, pero **alguna respuesta es incorrecta**. | Error en el algoritmo; caso especial olvidado; desbordamiento de `int`; procesar el caso final especial; texto de más (`"Introduce…"`); coma en vez de punto en decimales. | El juez no dice en qué caso falla. Vuelve a leer el enunciado y [prueba casos límite](03-probar-antes-de-enviar.md#4-inventa-tus-propios-casos-de-prueba). |
| 🔴 **CE** *Compilation Error* | El código **no compila**. | Lenguaje mal elegido; línea `package`; clase no `public`; tildes en el nombre de la clase; usar novedades de Java que el juez no admite (lambdas, `var`…); código copiado incompleto. | Comprueba que compila en tu ordenador y revisa las reglas del apartado 1 de [probar antes de enviar](03-probar-antes-de-enviar.md#1-prepara-el-programa-como-lo-va-a-recibir-el-juez). |
| 🔴 **RTE** *Run-time Error* | El programa **se ha detenido con un error** antes de terminar. | Excepción no capturada: `ArrayIndexOutOfBoundsException`, `NullPointerException`, división por cero (`ArithmeticException`), `NumberFormatException`, `NoSuchElementException` (intentar leer cuando ya no hay datos: tipo de entrada mal entendido). | Prueba con valores límite (tamaños máximos y mínimos de arrays). Revisa [cómo termina la entrada](01-tipos-de-problemas.md). |
| 🟠 **TLE** *Time Limit Exceeded* | Ha **tardado demasiado** y el juez lo ha cortado. | Algoritmo demasiado lento; bucle infinito (por ejemplo, no detectar el final de la entrada); `Scanner` con entradas enormes. | Normalmente hay que **cambiar de algoritmo**, no retocar detalles. Mira [rendimiento](03-probar-antes-de-enviar.md#5-comprueba-el-rendimiento-con-entradas-grandes). |
| 🟠 **MLE** *Memory Limit Exceeded* | Ha usado **más memoria** de la permitida. | Arrays enormes; guardar toda la entrada cuando se puede procesar caso a caso; crear muchísimos objetos. | Procesa cada caso según lo lees y reserva solo la memoria necesaria. |
| 🟠 **OLE** *Output Limit Exceeded* | Ha escrito **demasiada salida**. | No detectar el final de la entrada y seguir escribiendo; mensajes de depuración olvidados. | Revisa la condición de parada y quita los `println` de depuración. |
| ⚫ **RF** *Restricted Function* | Ha intentado una **operación prohibida**. | Abrir ficheros, usar la red, crear hilos, llamadas al sistema. | Lee solo de `System.in` y escribe solo en `System.out`. |
| ⚪ **IQ** *In Queue* | El envío **está en cola**, aún no se ha evaluado. | — | Espera y recarga. |
| ⚪ **IE** *Internal Error* | Fallo **del juez**, no de tu programa. | — | Vuelve a enviarlo más tarde. Si persiste, avisa a tu profesor. |

### Cosas que conviene saber
- **Solo se muestra un veredicto**, aunque tengas varios problemas a la vez. Por ejemplo, un programa que da respuestas incorrectas y además es lento puede recibir TLE, y cuando lo aceleres, WA.
- Un **AC no significa que no haya otros fallos**, sino que tu programa supera los casos del juez. Aun así, ¡es lo que cuenta!
- **El tiempo que aparece en la lista** puede ser mayor que el límite del enunciado aunque sea AC: el juez puede ejecutar tu programa con varios lotes de casos, y muestra el tiempo total, mientras que el límite se aplica a cada lote.
- Más detalles en la documentación oficial: [veredictos](https://aceptaelreto.com/doc/verdicts.php) y [preguntas frecuentes](https://aceptaelreto.com/doc/faq.php).

## Resumen: ¿qué miro primero?

```text
CE  → ¿Compila en mi ordenador? ¿package? ¿public? ¿lenguaje Java?
RTE → ¿Leo más datos de los que hay? ¿Índices fuera del array? ¿Divido por 0?
TLE → ¿Bucle infinito? ¿Algoritmo demasiado lento para el tamaño máximo?
WA  → ¿Casos límite? ¿int que desborda? ¿Proceso el caso final? ¿Texto de más?
PE  → diff/fc con la salida esperada: espacios y saltos de línea.
```
