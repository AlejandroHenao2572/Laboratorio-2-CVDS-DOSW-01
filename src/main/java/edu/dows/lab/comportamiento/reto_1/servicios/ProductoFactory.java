package edu.dows.lab.comportamiento.reto_1.servicios;

import edu.dows.lab.comportamiento.reto_1.modelo.Producto;

public class ProductoFactory {
    public static Producto crearProducto(String nombre, double precio, String categoria) {
        return new Producto(nombre, precio);
    }
}
