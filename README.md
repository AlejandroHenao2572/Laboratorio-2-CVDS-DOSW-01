# Laboratorio 02 - SOLID, Patrones de Diseño y UML

## Integrantes
- DAVID ALEJANDRO PATACON HENAO
- JUANA LOZANO CHAVES
- JUAN SEBASTIÁN GUAYAZÁN CLAVIJO

Desarrollo y Operaciones Software (ISIS DOSW-301)    
Decanatura Ingeniería de Sistemas  
Ingeniería de Sistemas  
Escuela Colombiana de Ingeniería Julio Garavito  
2025-2  

**Nombre de la rama:**
'feature/PataconDavid_LozanoJuana_GuayazanSebastian_2025-2'  

**Link word:** https://pruebacorreoescuelaingeduco-my.sharepoint.com/:w:/g/personal/juana_lozano-c_mail_escuelaing_edu_co/EauHoVI1Ut1BpCEiZjbW8WgBMEYhkxokSCEpDlHznqudZQ?e=dWrqvD

## Preguntas de preparación
1. ¿Qué ventaja ofrece el polimorfismo en el diseño de clases frente al uso de múltiples condicionales para determinar el comportamiento de un objeto?

El polimorfismo permite definir una interfaz común y que cada clase concreta implemente su propio comportamiento. De esta manera se evita múltiples condicionales (if, switch) en el código, lo que lo hace más legible, mantenible y extensible y así evita,como código espagueti
   
   - *Ejemplo:* en lugar de usar if(tipoAnimal == "Perro") → ladrar(), if(tipoAnimal == "Gato") → maullar(), se define un método hacerSonido() en la superclase y cada subclase lo implementa.

2. ¿Por qué una clase inmutable puede mejorar la seguridad?

Esto sucede pues se una el principio Open close por esto una clase inmutable no permite cambiar su estado después de creada. Evita modificaciones inesperadas en entornos concurrentes. Facilita la validación de datos, ya que el objeto no cambia una vez creado. Reduce riesgos de ataques por referencia (otro código no puede alterar sus atributos internos).

3. ¿Qué problema podría aparecer en un sistema si los atributos de las clases se mantienen públicos en lugar de privados con getters y setters controlados?

Se rompe el principio de encapsulamiento. Esto es porque cualquier parte del código puede cambiar los atributos sin control → inconsistencia en el estado del objeto. En adición, si las reglas de negocio cambian sería difícil de mantener y el código cliente se rompería.

4. Según el principio de Abierto/Cerrado, cómo deberíamos modificar el sistema si queremos añadir una nueva funcionalidad sin alterar el código existente?

El sistema debe estar abierto a la extensión y cerrado a la modificación. Para añadir una funcionalidad, se crea una nueva clase que extienda o implemente una interfaz existente, en lugar de modificar clases ya implementadas.

5. ¿Por qué es importante que una clase cumpla con el Principio de Única Responsabilidad y qué ejemplo sencillo podrías dar donde se vulnere?

Cada clase debe tener una sola razón de cambio. Si una clase tiene varias responsabilidades, se vuelve difícil de mantener y probar.

*Ejemplo de violación:*

```java
class Reporte {
    void generarReporte() { ... }
    void guardarEnArchivo() { ... }
    void enviarPorCorreo() { ... }
}
````

Aquí la clase mezcla lógica de negocio, persistencia y comunicación, violando el principio.

6. ¿Qué es y por qué usamos el pom.xml?

Es el archivo de configuración de Maven el cual contiene información del proyecto:

* Dependencias externas.
* Plugins necesarios.
* Configuración de compilación y empaquetado.
* Permite automatizar la construcción del proyecto y garantizar que todos los desarrolladores usen las mismas versiones de librerías.

7. ¿Qué diferencia hay entre mvn compile, mvn package y mvn install?

* mvn compile: compila el código fuente en bytecode, pero no genera artefacto.
* mvn package: compila y empaqueta el proyecto (en .jar o .war).
* mvn install: hace todo lo anterior y además instala el artefacto en el repositorio local (.m2) para que otros proyectos lo puedan usar.

8. ¿Qué diferencia existe entre una interfaz y una clase abstracta?

*Interfaz:*

- Define contratos (métodos sin implementación, hasta Java 7).
- Desde Java 8 puede tener métodos default y estáticos.
- Una clase puede implementar múltiples interfaces.

*Clase abstracta:*

* Puede tener métodos abstractos y métodos con implementación.
* Puede tener atributos y constructores.
* Una clase solo puede heredar de una clase abstracta (herencia simple).

*Regla práctica:*

* Usa interfaz para definir qué hace algo.
* Usa clase abstracta para definir qué es algo.

---
# Retos

## Reto 1  

### Patrón de Diseño: Comportamiento  
**Patrón Utilizado:** Strategy Pattern  

**Justificación:**  
El sistema necesitaba aplicar diferentes porcentajes de descuento según el tipo de cliente.  

**Cómo lo apliqué:**  
- Definí una interfaz llamada `EstrategiaDescuento`.  
- Contiene los métodos necesarios para el descuento según el tipo que la implemente.  
- Implementé las estrategias concretas según el cliente (`nuevo`, `frecuente`).  


### Patrón de Diseño: Creacional  
**Patrón Utilizado:** Factory Pattern  

**Justificación:**  
Se requería crear objetos `Cliente` con diferentes estrategias de descuento según un parámetro de entrada (tipo de cliente).  

**Cómo lo apliqué:**  
- Implementé una fábrica estática para crear clientes.  


### Patrón de Diseño: Estructural  
**Patrón Utilizado:** Facade Pattern  

**Justificación:**  
El sistema involucra múltiples componentes (`inventario`, `carrito`, `generador de recibos`, `clientes`) que requieren coordinación para realizar una venta completa.  

**Cómo lo apliqué:**  
- Implementé la fachada que coordina todos los subsistemas.  
- Creé un método fachada que simplifica todo el proceso de venta.

---
# Reto #2: El chef de 5 estrellas

## Patrón de Diseño
Creacional

## Patrón Utilizado
Builder (Constructor)

## Justificación
El patrón Builder es adecuado porque permite construir paso a paso un objeto complejo (en este caso, la hamburguesa con sus ingredientes personalizados) y encapsula el proceso de creación. Esto es especialmente útil cuando hay múltiples combinaciones posibles y queremos tener control sobre cómo se va construyendo el objeto final.

## Cómo lo aplicamos
- Utilizamos la clase `HamburguesaBuilder` para ir agregando ingredientes uno a uno.
- El usuario elige los ingredientes personalizados por entrada estándar.
- Al final, se construye la hamburguesa con todos los ingredientes seleccionados.
- El cálculo del precio total se realiza mediante streams en el método `calcularPrecioTotal()` de la clase `Hamburguesa`.
- Se muestra la lista completa de ingredientes junto con el precio total formateado.
---

## Reto 3: El Reino de los Vehículos  

### Patrón de Diseño: Creacional  
**Patrón Utilizado:** Factory Pattern  

**Justificación:**  
El sistema necesitaba crear múltiples tipos de vehículos (`Tierra`, `Acuático`, `Aéreo`) con diferentes modelos cada uno, y cada combinación de categoría-modelo tiene características específicas.  
El **Abstract Factory** encapsula la lógica compleja de creación, centraliza la construcción de objetos y permite agregar nuevos tipos de vehículos sin modificar el código cliente.  

**Cómo lo apliqué:**  
- Creé una clase abstracta `VehiculoFactory` con el método `factory` estático.  
- Implementé fábricas concretas para cada tipo: `VehiculoTierraFactory`, `VehiculoAcuaticoFactory`, `VehiculoAereoFactory`.  
- Cada fábrica concreta maneja la creación específica de sus modelos con las características según la categoría.  

### Patrón de Diseño: Comportamiento  
**Patrón Utilizado:** Strategy Pattern  

**Justificación:**  
El sistema requiere flexibilidad para aplicar diferentes políticas de descuento según el método de pago (`contado`, `crédito` u otros que se agreguen).  
Este patrón permite intercambiar algoritmos de descuento dinámicamente y facilita agregar nuevos métodos de pago sin modificar el código existente.  

**Cómo lo apliqué:**  
- Definí la interfaz `EstrategiaPago` con métodos para calcular descuentos.  
- Implementé estrategias concretas: `PagoContado` (5% descuento) y `PagoCredito` (sin descuento).  
- El sistema puede cambiar la estrategia de pago dinámicamente.  
- Facilita agregar nuevos métodos como `PagoTarjeta`, `PagoBancario`, etc.  

### Patrón de Diseño: Comportamiento  
**Patrón Utilizado:** Command Pattern  

**Justificación:**  
Se necesitaba encapsular la operación de procesar una compra (mostrar resumen, calcular totales, aplicar descuentos) en un objeto independiente.  
Esto permite ejecutar, deshacer o registrar operaciones de compra de manera flexible.  

**Cómo lo apliqué:**  
- Creé la interfaz `ComandoCompra` con el método `ejecutar()`.  
- Implementé `ProcesarCompra` que encapsula toda la lógica de procesamiento.  
- El comando recibe la lista de vehículos y la estrategia de pago.  
- Utiliza **streams** para calcular el total.  

### Patrón de Diseño: Estructural  
**Patrón Utilizado:** Facade Pattern  

**Justificación:**  
El sistema involucra múltiples subsistemas (`factories`, `estrategias de pago`, `comandos`) que requieren coordinación.  
El **Facade Pattern** proporciona una interfaz que oculta toda esta complejidad al usuario final.  

**Cómo lo apliqué:**  
- Implementé `Concesionario` que coordina todos los subsistemas.  
- Métodos como `iniciarCompra()`, `agregarVehiculo()`, `procesarCompraFinal()` simplifican operaciones complejas.  
- Centraliza el flujo de la aplicación y maneja la interacción con el usuario.  

---
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
---
# Reto #5: El Café Personalizado

## Patrón de Diseño
Patrón de diseño estructural.

## Patrón Utilizado
Decorator (Decorador).

## Justificación
El patrón Decorator es ideal para agregar funcionalidades (toppings) a un objeto base (café) sin modificar la clase base. Esto permite combinar múltiples toppings de forma dinámica y respetando la extensibilidad del sistema.

## Cómo lo aplicamos
El café base se representa con una clase `CafeBase`. Cada topping es un decorador (`Topping`) que envuelve la instancia de `Cafe` y agrega su descripción y precio. Esto permite añadir una cantidad arbitraria de toppings a cualquier café sin cambiar su código base.

Además, se utiliza un `ToppingManager` para mantener una lista dinámica de toppings disponibles, permitiendo agregar nuevos toppings en tiempo de ejecución sin modificar la base.

Para calcular el total general cuando hay varios cafés y toppings, se usan streams de Java.

## Uso

1. Se solicita la cantidad de cafés a personalizar.
2. El usuario selecciona toppings para cada café mediante números.
3. Si el usuario desea agregar un topping nuevo, puede seleccionar la opción correspondiente e ingresar el nombre y precio del mismo.
4. Al final se muestra un resumen detallado de cada café con su descripción y precio, además del total general.
   
---

## Reto 6  

### Patrón de Diseño: Comportamiento  
**Patrón Utilizado:** Chain of Responsibility Pattern  

**Justificación:**  
Permite desacoplar emisores y receptores: cada técnico decide si procesa o pasa el ticket al siguiente.  

**Cómo lo apliqué:**  
- Creé una clase abstracta `Tecnico` con el método `procesarTicket()`.  
- Cada implementación concreta decide si procesa el ticket según sus capacidades.  


### Patrón de Diseño: Creacional  
**Patrón Utilizado:** Factory Method Pattern  

**Justificación:**  
Centraliza la creación compleja de la cadena de responsabilidad.  

**Cómo lo apliqué:**  
- Implementé `CadenaResponsabilidadFactory` que configura automáticamente la secuencia de técnicos.  


### Patrón de Diseño: Comportamiento  
**Patrón Utilizado:** Command Pattern  

**Justificación:**  
Encapsula la operación de procesar todos los tickets y generar estadísticas.  

**Cómo lo apliqué:**  
- Implementé `ProcesarTicketsComando` que ejecuta todo el flujo de procesamiento.  

---

# RETO #7 – El Control Remoto Mágico

**Patrón de Diseño:**
Comportamiento

**Patrón Utilizado:**
Command

**Justificación:**
Cada acción del control remoto (encender luz, abrir puerta, reproducir música, ajustar volumen, etc.) se modela como un **comando** que encapsula tanto la operación como los parámetros necesarios para ejecutarla o deshacerla.
El patrón **Command** permite:

* Ejecutar y deshacer acciones de forma flexible.
* Registrar un historial de operaciones para luego auditar quién hizo qué.
* Tratar cada acción como un objeto independiente, facilitando la extensión (añadir nuevos comandos sin modificar el código existente).

**Cómo lo apliqué:**

* Creé una interfaz `Command` con los métodos `execute()` y `undo()`.
* Para cada acción (Luz, Puerta, Música, Volumen), implementé una clase concreta de comando.
* El control remoto mantiene un historial de acciones ejecutadas para permitir **deshacer** y **auditar** quién ejecutó qué acción.
* El sistema registra el usuario que ejecuta la acción y, al final, genera un resumen de los cambios realizados y quién desconfiguró los dispositivos.
---

# Reto 8: Zoologico UML

## 1. Principios SOLID

### Single Responsibility Principle  
Cada clase tiene una única responsabilidad:
- **Animal**: Mantiene los datos básicos y comportamientos comunes de los animales.
- **Cuidador**: Maneja las responsabilidades de cuidado y gestión de animales.
- **Visitante**: Se enfoca en las interacciones del visitante.
- **Fotografia**: Maneja únicamente los datos relacionados con las fotografías.
- **GestorNotificaciones**: Administra el sistema de notificaciones.

### Open/Closed Principle  
- Las clases **Mamifero**, **Reptil** y **Ave** extienden la clase abstracta **Animal** sin modificarla.
- Es posible agregar nuevos tipos de animales extendiendo la clase **Animal**.
- El uso de **atributos dinámicos** permite añadir características sin alterar la estructura base.

##Liskov Substitution Principle  
- Cualquier instancia de **Mamifero**, **Reptil** o **Ave** puede usarse donde se espere un **Animal**.
- Los métodos abstractos aseguran que cada subclase mantenga el comportamiento esperado.

### Interface Segregation Principle  
Interfaces específicas para cada responsabilidad:
- **InteraccionAnimal**: Interacciones básicas con animales.
- **InteraccionHabitat**: Mantenimiento del hábitat.
- **ObservadorEstadoSalud**: Notificaciones de cambios de estado.
- Los clientes (**Cuidador**, **Visitante**) implementan solo las interfaces que realmente necesitan.


### Dependency Inversion Principle (DIP)
- Las clases de alto nivel dependen de **abstracciones (interfaces)**, no de implementaciones concretas.
- El sistema de notificaciones utiliza la abstracción **ObservadorEstadoSalud**.


## 2. Patrones de Diseño Aplicados

### Factory Pattern
- **AnimalFactory** centraliza la creación de diferentes tipos de animales, facilitando el mantenimiento y la consistencia.

### Observer Pattern
- **ObservadorEstadoSalud** y **GestorNotificaciones** permiten notificar automáticamente cuando cambia el estado de salud de un animal.

## 3. Diseño UML

### Herencia y Polimorfismo
- Herencia  entre **Animal** y sus subclases (**Mamifero, Reptil, Ave**).
- Métodos abstractos garantizan polimorfismo.

### Encapsulación
- Todos los atributos son **privados**.
- Uso de **getters y setters** públicos para acceso controlado.


### Asociaciones
- Asociaciones coherentes con los requirimientos y diseño del problema

### Atributos Dinámicos
- La clase **Animal** incluye `Map<String, Object> atributosDinamicos` para agregar características como:
  - Color de pelaje
  - Origen
  - Rareza
  - Historial médico  


