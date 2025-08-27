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

---

## Uso

1. Se solicita la cantidad de cafés a personalizar.
2. El usuario selecciona toppings para cada café mediante números.
3. Si el usuario desea agregar un topping nuevo, puede seleccionar la opción correspondiente e ingresar el nombre y precio del mismo.
4. Al final se muestra un resumen detallado de cada café con su descripción y precio, además del total general.