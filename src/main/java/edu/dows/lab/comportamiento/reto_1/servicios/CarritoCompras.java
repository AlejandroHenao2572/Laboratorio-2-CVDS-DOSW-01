package edu.dows.lab.comportamiento.reto_1.servicios;

import edu.dows.lab.comportamiento.reto_1.modelo.ItemCarrito;
import edu.dows.lab.comportamiento.reto_1.modelo.Producto;
import java.util.ArrayList;
import java.util.List;


public class CarritoCompras {
    private final List<ItemCarrito> items;
    
    public CarritoCompras() {
        this.items = new ArrayList<>();
    }
    
    public void agregarProducto(Producto producto, int cantidad) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        
        ItemCarrito item = new ItemCarrito(producto, cantidad);
        items.add(item);
        System.out.printf("%s %d unidades agregado al carrito.%n", 
                         producto.getNombre(), cantidad);
    }
    
    public double calcularSubtotal() {
        return items.stream()
                   .mapToDouble(ItemCarrito::getSubtotal)
                   .reduce(0.0, Double::sum);
    }
    
    public List<ItemCarrito> getItems() {
        return new ArrayList<>(items);
    }
    
    public boolean estaVacio() {
        return items.isEmpty();
    }
    
    public void limpiar() {
        items.clear();
        System.out.println("Carrito limpiado.");
    }
    
    public int getCantidadItems() {
        return items.stream()
                   .mapToInt(ItemCarrito::getCantidad)
                   .sum();
    }
    
    public void mostrarContenido() {
        if (estaVacio()) {
            System.out.println("El carrito está vacío.");
            return;
        }
        
        System.out.println("Contenido del carrito:");
        items.stream()
             .forEach(item -> System.out.println("- " + item));
        System.out.printf("Total items: %d%n", getCantidadItems());
    }
}