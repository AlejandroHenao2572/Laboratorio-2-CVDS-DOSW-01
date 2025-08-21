package edu.dows.lab.comportamiento.tienda.servicios;

import edu.dows.lab.comportamiento.tienda.modelo.Cliente;
import edu.dows.lab.comportamiento.tienda.modelo.Producto;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class SistemaTienda {
    private final Map<String, Producto> inventario;
    private final GeneradorRecibo generadorRecibo;
    
    public SistemaTienda() {
        this.inventario = new HashMap<>();
        this.generadorRecibo = new GeneradorRecibo();
        inicializarInventario();
    }
    
    private void inicializarInventario() {
    inventario.put("camiseta", InventarioProductos.obtenerCamiseta());
    inventario.put("pantalon", InventarioProductos.obtenerPantalon());
    inventario.put("galletas", InventarioProductos.obtenerGalletas());
    inventario.put("jugo", InventarioProductos.obtenerJugo());
    }
    
    public void mostrarBienvenida() {
        System.out.println("=================================");
        System.out.println("  BIENVENIDO A LA TIENDA DON PEPE");
        System.out.println("=================================");
    }
    
    public void mostrarProductosDisponibles() {
        System.out.println("\nProductos disponibles:");
        inventario.values().stream()
                  .forEach(producto -> System.out.println("-- " + producto));
    }
    
    public Producto buscarProducto(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return null;
        }
        return inventario.get(nombre.toLowerCase().trim());
    }
    
    public Set<String> obtenerNombresProductos() {
        return inventario.keySet();
    }
    
    public boolean existeProducto(String nombre) {
        return buscarProducto(nombre) != null;
    }
    
    public void procesarVenta(String tipoCliente, CarritoCompras carrito) {
        try {
            Cliente cliente = ClienteFactory.crearCliente(tipoCliente);
            generadorRecibo.generarRecibo(cliente, carrito);
        } catch (IllegalArgumentException e) {
            System.err.println("Error al procesar la venta: " + e.getMessage());
        }
    }
    
    public void mostrarTiposClienteDisponibles() {
        System.out.println("\nTipos de cliente disponibles:");
        String[] tipos = ClienteFactory.getTiposClienteDisponibles();
        for (String tipo : tipos) {
            System.out.println("• " + tipo);
        }
    }
}