# RETO #4 – La Estafa de la Casa de Cambio

**Patrón de Diseño:**
Creacionales

**Patrón Utilizado:**
Factory Method

**Justificación:**
El problema requiere crear objetos de conversión dependiendo de la moneda seleccionada por el usuario. Si usáramos condicionales en todo el código (`if`/`switch`), sería difícil de mantener y extender (por ejemplo, al agregar nuevas monedas). Con **Factory Method**, centralizamos la lógica de creación en una clase “fábrica” que devuelve el conversor adecuado, haciendo el sistema más flexible y extensible.

**Cómo lo apliqué:**

* Creé una interfaz `CurrencyConverter` con un método `convert(double amount)`.
* Para cada moneda de destino (USD, EUR, JPY, COP), definí una clase concreta que implementa esa interfaz.
* Implementé una clase `CurrencyConverterFactory` que decide qué conversor crear según la moneda solicitada.
* El programa principal solicita las transacciones al usuario, crea los conversores usando la fábrica y realiza la conversión.
* Usé **streams** para sumar los resultados y mostrar totales por moneda.

