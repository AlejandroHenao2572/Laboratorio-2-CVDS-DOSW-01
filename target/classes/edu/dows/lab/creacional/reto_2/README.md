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

