package edu.dows.lab.comportamiento.tienda.modelo;

public class Producto {
    private final String nombre;
    private final double precio;
    
    public Producto(String nombre, double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    @Override
    public String toString() {
        return String.format("%s - $%.0f", nombre, precio);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producto producto = (Producto) obj;
        return Double.compare(producto.precio, precio) == 0 && 
               nombre.equals(producto.nombre);
    }
    
    @Override
    public int hashCode() {
        return nombre.hashCode() + Double.hashCode(precio);
    }
}