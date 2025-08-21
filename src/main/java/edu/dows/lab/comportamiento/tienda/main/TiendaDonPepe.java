package edu.dows.lab.comportamiento.tienda.main;

import edu.dows.lab.comportamiento.tienda.modelo.Producto;
import edu.dows.lab.comportamiento.tienda.servicios.CarritoCompras;
import edu.dows.lab.comportamiento.tienda.servicios.SistemaTienda;

public class TiendaDonPepe {
    
    public static void main(String[] args) {
        // Crear el sistema de tienda
        SistemaTienda tienda = new SistemaTienda();
        
        // Mostrar bienvenida y productos disponibles
        tienda.mostrarBienvenida();
        tienda.mostrarProductosDisponibles();
        
        // Ejecutar escenario de ejemplo
        ejecutarEscenarioEjemplo(tienda);
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Fin del programa.");
    }
    
    private static void ejecutarEscenarioEjemplo(SistemaTienda tienda) {
        System.out.println("\n--- ESCENARIO DE EJEMPLO ---");
        
        // Crear carrito de compras
        CarritoCompras carrito = new CarritoCompras();
        
        // Definir tipo de cliente
        String tipoCliente = "frecuente";
        System.out.println("Cliente: " + tipoCliente.substring(0, 1).toUpperCase() + 
                          tipoCliente.substring(1));
        
        System.out.println("\nIngrese su compra:");
        
        // Agregar productos al carrito segun el ejemplo
        agregarProductosEjemplo(tienda, carrito);
        
        // Procesar la venta
        tienda.procesarVenta(tipoCliente, carrito);
    }
    
    private static void agregarProductosEjemplo(SistemaTienda tienda, CarritoCompras carrito) {
        // Productos del escenario ejemplo
        String[][] compras = {
            {"camiseta", "2"},
            {"galletas", "3"},
            {"jugo", "5"}
        };
        
        for (String[] compra : compras) {
            String nombreProducto = compra[0];
            int cantidad = Integer.parseInt(compra[1]);
            
            Producto producto = tienda.buscarProducto(nombreProducto);
            if (producto != null) {
                carrito.agregarProducto(producto, cantidad);
            } else {
                System.err.printf("Producto '%s' no encontrado en el inventario%n", 
                                nombreProducto);
            }
        }
    }
}