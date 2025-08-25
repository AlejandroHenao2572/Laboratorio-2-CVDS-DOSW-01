# Laboratorio 02 - SOLID, Patrones de Diseño y UML

## Integrantes
- DAVID ALEJANDRO PATACON HENAO
- JUANA LOZANO CHAVES
- JUAN SEBASTIÁN GUAYAZÁN CLAVIJO

Arquitectura y Servicios de Red (ISIS AYSR-5L)   
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

### Ejecucion:  
<img width="416" height="655" alt="image" src="https://github.com/user-attachments/assets/d2316178-2cc9-403d-8fc3-e073866457b5" />  

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

### Ejecucion:
<img width="477" height="870" alt="image" src="https://github.com/user-attachments/assets/5d2c7698-e639-49b3-907e-72cc9f3d8770" />  
<img width="413" height="553" alt="image" src="https://github.com/user-attachments/assets/deff1e0f-f26a-4bab-8a72-84716178ed17" />

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

### Ejecucion:
<img width="437" height="600" alt="image" src="https://github.com/user-attachments/assets/50224479-5bb6-464e-9fc1-a2a75b06d503" />  
<img width="662" height="303" alt="image" src="https://github.com/user-attachments/assets/384225e7-9c5d-4c80-bff7-c4310e25f2e9" />



