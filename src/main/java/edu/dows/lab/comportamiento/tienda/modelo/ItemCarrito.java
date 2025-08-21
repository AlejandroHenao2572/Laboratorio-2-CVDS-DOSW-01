package edu.dows.lab.comportamiento.tienda.modelo;

public class ItemCarrito {
    private final Producto producto;
    private final int cantidad;
    
    public ItemCarrito(Producto producto, int cantidad) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        this.producto = producto;
        this.cantidad = cantidad;
    }
    
    public Producto getProducto() {
        return producto;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public double getSubtotal() {
        return producto.getPrecio() * cantidad;
    }
    
    @Override
    public String toString() {
        return String.format("%s x%d - $%.0f", 
                           producto.getNombre(), cantidad, getSubtotal());
    }
}