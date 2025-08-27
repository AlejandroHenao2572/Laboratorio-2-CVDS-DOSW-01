# Laboratorio-2-CVDS-DOSW-01

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