# Método de la Secante - Métodos Numéricos

## Descripción
Este proyecto implementa el **método de la secante**, un algoritmo iterativo de métodos numéricos utilizado para encontrar raíces de una función \( f(x) = 0 \). A diferencia de otros métodos como Newton-Raphson, el método de la secante no requiere calcular la derivada de la función, sino que la aproxima usando dos puntos consecutivos.

## Propósito
El objetivo de este código es:
- Encontrar una raíz aproximada de una ecuación no lineal utilizando el método de la secante.
- Demostrar la implementación del método en un programa en Java con Maven.
- Proporcionar una herramienta educativa para estudiantes de métodos numéricos.

## Cómo funciona
El método de la secante sigue estos pasos:
1. Se selecciona dos aproximaciones iniciales \( x_0 \) y \( x_1 \) cercanas a la raíz.
2. Se evalúa la función \( f(x) \) en estos puntos: \( f(x_0) \) y \( f(x_1) \).
3. Para cada iteración \( n \), se calcula una nueva aproximación \( x_{n+1} \) usando la fórmula:

   ![Fórmula del Método de la Secante](https://github.com/Yovanygt/metodo_secante/raw/main/secante_formula.png)

   Donde:
   - \( x_{n+1} \): Nueva aproximación en la iteración \( n+1 \).
   - \( x_n \), \( x_{n-1} \): Aproximaciones de las iteraciones anteriores.
   - \( f(x_n) \), \( f(x_{n-1}) \): Valores de la función en \( x_n \) y \( x_{n-1} \).
4. Si \( f(x_{n+1}) \) es lo suficientemente pequeño (dentro de una tolerancia), \( x_{n+1} \) es la raíz aproximada.
5. Si no, se repite el proceso usando \( x_n \) y \( x_{n+1} \) como los nuevos puntos, hasta que se cumpla la tolerancia o se alcance un número máximo de iteraciones.

## Requisitos
- Java 8 o superior.
- Maven para la gestión de dependencias.
- Un entorno de desarrollo como IntelliJ IDEA, Eclipse o similar.
- La librería Exp4j para evaluar expresiones matemáticas (definida en el `pom.xml`).

## Uso
1. Clona este repositorio:
   ```
   git clone https://github.com/Yovanygt/metodo_secante.git
   ```
2. Navega al directorio del proyecto y compila con Maven:
   ```
   mvn clean install
   ```
3. Ejecuta el programa desde tu entorno de desarrollo o con Maven:
   ```
   mvn exec:java -Dexec.mainClass="tu.paquete.principal.ClasePrincipal"
   ```
   (Ajusta `tu.paquete.principal.ClasePrincipal` según el nombre de tu clase principal).
4. Ingresa las dos aproximaciones iniciales \( x_0 \) y \( x_1 \), la función \( f(x) \), y la tolerancia cuando se soliciten.

## Estructura del Proyecto
- `src/`: Contiene el código fuente en Java.
- `pom.xml`: Archivo de configuración de Maven con las dependencias del proyecto (incluye Exp4j).
- `target/`: Directorio generado por Maven con los archivos compilados (no versionado en Git).

## Licencia
Este proyecto está bajo la licencia MIT. Consulta el archivo `LICENSE` para más detalles (si aplica).

## Autor
- Yovanygt
