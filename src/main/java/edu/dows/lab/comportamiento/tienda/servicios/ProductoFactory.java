package edu.dows.lab.comportamiento.tienda.servicios;

import edu.dows.lab.comportamiento.tienda.modelo.Producto;

public class ProductoFactory {
    public static Producto crearProducto(String nombre, double precio, String categoria) {
        return new Producto(nombre, precio);
    }
}
