# Normas para aportar en este repositorio.

## Normas para aportar soluciones a problemas.
Antes de realizar una push request para subir la solución a un problema, asegurate de seguir y entender estas normas:

1. **Sólo se admitirán soluciones aceptadas (AC) en aceptaelreto.com.**

   Sólo se admitirán push request de soluciones que funcionen y que hayan sido comprobadas en aceptaelreto.com. No basta con que el programa Java pase los casos de prueba de ejemplo, se debe haber conseguido un "Accepted" en aceptaelreto.com. Antes de aceptar la push request, se ejecutará la solución propuesta en acepta el reto, y se verificará su funcionamiento.

3. **Sólo se admitirán soluciones una a una.**

   Una push request debe contener sólo la solución a un problema de aceptaelreto.com. Si se proponen soluciones a más de un problema, la push request se rechazará, sin valorar las soluciones propuestas, que deberán volver a enviarse por separado.

3. **Un directorio por problema**.

   Por cada problema de acepta el reto se debe crear un directorio dedicado, de la forma "problema<numero><textodescriptivo>".
   Por ejemplo, el problema 191, titulado "Los problemas de ser rico", podría estar en el directorio "problema191problemasserrico".
   Otro ejemplo, el problema 568, titulado "No queda otra, habrá que hacer cursos", podría estar en "problema568habraquehacercursos"
   Estos nombres deben estar completamente en minúsculas, para seguir las convenciones de Java, que interpretará la carpeta como un paquete.

5. **Programa con el mismo nombre que el directorio**.

   El programa para resolver el problema se llamará igual que el directorio, pero añadiendo la extensión .java.

7. **Se pueden proponer versiones alternativas**.

   Muchos problemas se pueden resolver de más de una forma. Os animamos a compartir otras formas de resolverlos. En este caso, a cada versión se añadirá "_vXX", siendo XX el número de versión.
   Ejemplo, si ya tenemos una solución en problema191problemasserrico/problema191problemasserrico.java, se puede proponer otra en "problema191problemasserrico/problema191problemasserrico_v02.java".
   Todas las soluciones a un mismo problema deben ubicarse en el mismo directorio, el dedicado específicamente a ese problema.

8. **Todo el código debe estar en un único fichero Java**.

    Algunos problemas es más fácil resolverlos usando estructuras de datos, y a veces se necesitan clases adicionales, como implementaciones de un comparador, o una clase para almacenar datos de entrada o de salida. Todas estas clases adicionales a la del programa, deberán estar definidas en el mismo fichero de la solución, como clases internas o estáticas. La idea es que se pueda copiar / pegar el código de la clase en Acepta el reto y probarlo sin necesidad de hacer cambios de ninguna clase.
   
9. **No se deben utilizar dependencias externas**.

   Esto es un poco evidente, pero ya que en "Acepta el reto" no se pueden usar dependencias externas, las soluciones propuestas no podrá utilizar estructuras de datos o funcionalidades de otros paquetes, como Apache Commons o similares.

   
9. **No se deben subir ficheros de proyecto del entorno de desarrollo**.

   El directorio "soluciones", que originalmente era una carpeta de proyecto eclipse, se ha reorganizado para que sea, simplemente, una carpeta "normal", con una subcarpeta para cada uno de los problemas, y programas .java en estas carpetas. La idea es que no haya en el repositorio ninguna clase de metadatos o configuración de proyecto de ningún entorno de desarrollo o editor de código (Eclipse, IntelliJ Idea, VS Code, etc.). Tampoco habrá ninguna clase de configuración respecto a versión de Java o SDK utilizado. Si se desea probar los problemas en un entorno local, se pueden descargar o clonar el repositorio, y usar el editor que se prefiera. 




