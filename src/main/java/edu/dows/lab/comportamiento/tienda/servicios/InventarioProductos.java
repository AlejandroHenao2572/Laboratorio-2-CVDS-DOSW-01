package edu.dows.lab.comportamiento.tienda.servicios;

import edu.dows.lab.comportamiento.tienda.modelo.Producto;

public class InventarioProductos {
    public static Producto obtenerCamiseta() {
        return ProductoFactory.crearProducto("Camiseta", 20000, "ropa");
    }
    public static Producto obtenerPantalon() {
        return ProductoFactory.crearProducto("Pantalon", 50000, "ropa");
    }
    public static Producto obtenerGalletas() {
        return ProductoFactory.crearProducto("Galletas", 500, "alimento");
    }
    public static Producto obtenerJugo() {
        return ProductoFactory.crearProducto("Jugo Natural", 3000, "bebida");
    }
}
