# Normas para aportar en este repositorio.

## Normas para aportar soluciones a problemas.
Desde el equipo de preparación de ProgramaMe en el IES Clara del Rey estaremos encantados de que cualquier persona interesada, sea alumno o no del centro, aporte soluciones a problemas de aceptaelreto.com.

El objetivo de este repositorio no es simplemente disponer de soluciones, sino que sea un recurso de aprendizaje de algoritmia en general, y programación competitiva en particular.

Por eso, se han establecido una serie de normas que debe cumplir cualquier aportación al repositorio. 

De momento se admitirán sólo soluciones a problemas. En un futuro puede que se amplíe el espectro a aportaciones con contenido teórico, ejemplos de aplicación de algoritmos, enlaces, artículos, recursos, etc. Pero de momento se va a valorar solo las aportaciones de soluciones.

Antes de realizar una push request para subir la solución a un problema, asegurate de seguir y entender estas normas y recomendaciones:

1. **Sólo se admitirán soluciones aceptadas (AC) en aceptaelreto.com.**

   Sólo se admitirán push request de soluciones que funcionen y que hayan sido comprobadas en aceptaelreto.com. No basta con que el programa Java pase los casos de prueba de ejemplo, se debe haber conseguido un "Accepted" en aceptaelreto.com. Antes de aceptar la push request, se ejecutará la solución propuesta en acepta el reto, y se verificará su funcionamiento.

2. **Las soluciones deben escritas con un estilo "didáctico".**

   Como se ha indicado, el objeto de este repositorio es fundamentalmente didáctico. Esto implica que todas las soluciones propuestas deberían estar escritas de forma que se puedan interpretar fácilmente, incluso por aquellas personas que no tienen un conocmiento profundo en programación de algoritmos. Se recomienda seguir, siempre que sea posible, las siguientes recomendaciones:
   - *Usar nombres de variables con sentido*. Evitar variables, *a*, *b*, *c*, o similares, y utilizar variables con sentido, como *numCasos*, *numPersonas*, *filaActual*, etc.
   - *Usar métodos siempre que se considere necesario y sea viable*. Implementar la solución dividiendo el problema en partes más pequeñas, si es posible. Cuando se compite en un concurso no siempre es posible, pero en el caso de un problema que se resuelve tranquilamente en casa, y que se quiere compartir con la comunidad, podemos tomarnos el tiempo necesario para hacer que sea más estructurado.
   - *Usar comentarios iniciales y en el código*. Incluir un comentario inicial, en el que se explica cómo se soluciona el problema, con qué tecnicas, ayuda como primera aproximación. Por ejemplo, si se usan listas, colas, diccionarios o conjuntos, si se usa recursividad, backtracking o programación dinámica, si se usa un algoritmo específico como BSF, DSF, Dijkstra o cualquier otro. Además, los comentarios en el código explicando cosas no obvias ayudarán a seguir la lógica de la solución. 
   
3. **Sólo se admitirán soluciones un problema por push request, no a varios problemas .**

   Una push request debe contener sólo la solución a un problema de aceptaelreto.com. Si se proponen soluciones a más de un problema, la push request se rechazará, sin valorar las soluciones propuestas, que deberán volver a enviarse por separado.

4. **Un directorio por problema**.

   Por cada problema de acepta el reto se debe crear un directorio dedicado, de la forma "problema<numero><textodescriptivo>".
   Por ejemplo, el problema 191, titulado "Los problemas de ser rico", podría estar en el directorio "problema191problemasserrico".
   Otro ejemplo, el problema 568, titulado "No queda otra, habrá que hacer cursos", podría estar en "problema568habraquehacercursos"
   Estos nombres deben estar completamente en minúsculas, para seguir las convenciones de Java, que interpretará la carpeta como un paquete.

5. **Programa con el mismo nombre que el directorio**.

   El programa para resolver el problema se llamará igual que el directorio, pero añadiendo la extensión .java, y se seguirán las convenciones para clases Java, es decir, UpperCamelCase. Poir ejemplo, la solución para el problema "Los problemas de ser rico" deberá ser Soluciones/problema191problemasserrico/**Problema191ProblemasSerRico.java**.

6. **Se pueden proponer versiones alternativas**.

   Muchos problemas se pueden resolver de más de una forma. Os animamos a compartir otras formas de resolverlos. En este caso, a cada versión se añadirá "_vXX", siendo XX el número de versión.
   Ejemplo, si ya tenemos una solución en problema191problemasserrico/problema191problemasserrico.java, se puede proponer otra en "problema191problemasserrico/problema191problemasserrico_v02.java".
   Todas las soluciones a un mismo problema deben ubicarse en el mismo directorio, el dedicado específicamente a ese problema.

7. **Todo el código debe estar en un único fichero Java**.

    Algunos problemas es más fácil resolverlos usando estructuras de datos, y a veces se necesitan clases adicionales, como implementaciones de un comparador, o una clase para almacenar datos de entrada o de salida. Todas estas clases adicionales a la del programa, deberán estar definidas en el mismo fichero de la solución, como clases internas o estáticas. La idea es que se pueda copiar / pegar el código de la clase en Acepta el reto y probarlo sin necesidad de hacer cambios de ninguna clase.
   
8. **No se deben utilizar dependencias externas**.

   Esto es un poco evidente, pero ya que en "Acepta el reto" no se pueden usar dependencias externas, las soluciones propuestas no podrá utilizar estructuras de datos o funcionalidades de otros paquetes, como Apache Commons o similares.

   
9. **No se deben subir ficheros de proyecto del entorno de desarrollo**.

   El directorio "soluciones", que originalmente era una carpeta de proyecto eclipse, se ha reorganizado para que sea, simplemente, una carpeta "normal", con una subcarpeta para cada uno de los problemas, y programas .java en estas carpetas. La idea es que no haya en el repositorio ninguna clase de metadatos o configuración de proyecto de ningún entorno de desarrollo o editor de código (Eclipse, IntelliJ Idea, VS Code, etc.). Tampoco habrá ninguna clase de configuración respecto a versión de Java o SDK utilizado. Si se desea probar los problemas en un entorno local, se pueden descargar o clonar el repositorio, y usar el editor que se prefiera. 

10. **El equipo del IES Clara del Rey se reserva el derecho de modificar las soluciones propuestas**.

    Cualquier solución propuesta, una vez aceptada, puede ser modificada por el equipo de coordinación del concurso ProgramMe en el IES Clara del Rey. Estas modificaciones siempre estarán encaminadas a mejorar el problema en uno o varios de estos aspectos:
    - Mejorar el estilo del programa, modificando nobres de variables, refactorizando para extrar métodos, etc.
    - Completar la documentación, añadiendo comentarios o modificando los existentes, para que tenga una mejor aplicación didáctica.
    - Mejorar el rendimiento haciendo cambios en tipos de datos, optimizando bucles, etc.
   
   En el caso de cambios "radicales", como por ejemplo, mejorar rendimiento cambiando un algoritmo recursivo por uno iterativo, se propondrán soluciones alternativas al problema, siquiendo las indicaciones al respecto ya menocionadas..


