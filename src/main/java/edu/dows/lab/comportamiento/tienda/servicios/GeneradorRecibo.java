package edu.dows.lab.comportamiento.tienda.servicios;

import edu.dows.lab.comportamiento.tienda.modelo.Cliente;

public class GeneradorRecibo {
    
    public void generarRecibo(Cliente cliente, CarritoCompras carrito) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo");
        }
        if (carrito == null) {
            throw new IllegalArgumentException("El carrito no puede ser nulo");
        }
        if (carrito.estaVacio()) {
            System.out.println("El carrito esta vacío. No se puede generar el recibo.");
            return;
        }
        
        double subtotal = carrito.calcularSubtotal();
        double descuento = cliente.aplicarDescuento(subtotal);
        double total = subtotal - descuento;
        
        imprimirRecibo(cliente, carrito, subtotal, descuento, total);
    }
    
    private void imprimirRecibo(Cliente cliente, CarritoCompras carrito, 
                               double subtotal, double descuento, double total) {
        System.out.println("\n--- RECIBO DE COMPRA ---");
        System.out.println("Cliente: " + cliente.getTipoCliente());
        System.out.println("Productos:");
        
        // Usar streams para mostrar los productos
        carrito.getItems().stream()
               .forEach(item -> System.out.printf("- %s - %s%n", 
                       item.getProducto().getNombre(), 
                       formatearMoneda(item.getSubtotal())));
        
        System.out.println();
        System.out.println("Subtotal: " + formatearMoneda(subtotal));
        System.out.println("Descuento aplicado: " + formatearMoneda(descuento));
        System.out.println("Total a pagar: " + formatearMoneda(total));
        System.out.println("------------------------");
        System.out.println("¡Gracias por su compra!");
    }
    
    private String formatearMoneda(double cantidad) {
        return String.format("$%.0f", cantidad);
    }
}