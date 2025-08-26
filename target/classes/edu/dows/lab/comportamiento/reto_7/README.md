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


