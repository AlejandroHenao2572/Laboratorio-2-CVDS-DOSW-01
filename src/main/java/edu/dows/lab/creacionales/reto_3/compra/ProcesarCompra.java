package edu.dows.lab.creacionales.reto_3.compra;

import edu.dows.lab.creacionales.reto_3.vehiculos.*;
import edu.dows.lab.creacionales.reto_3.pagos.*;
import java.util.List;

public class ProcesarCompra implements ComandoCompra {
    private final List<Vehiculo> vehiculos;
    private final TipoPago tipoPago;
    
    public ProcesarCompra(List<Vehiculo> vehiculos, TipoPago tipoPago) {
        this.vehiculos = vehiculos;
        this.tipoPago = tipoPago;
    }
    
    @Override
    public void ejecutar() {
        mostrarResumenCompra();
    }
    
    private void mostrarResumenCompra() {
        System.out.println("\n---- RESUMEN DE COMPRA ----");
        
        for (int i = 0; i < vehiculos.size(); i++) {
            System.out.printf("Vehículo %d:\n%s\n\n", (i + 1), vehiculos.get(i));
        }
        
        // Usar streams para calcular totales
        double subtotal = vehiculos.stream().mapToDouble(Vehiculo::getPrecio).sum();

        double descuento = tipoPago.calcularDescuento(subtotal);
        double total = subtotal - descuento;
        
        System.out.printf("Subtotal: $%,.0f\n", subtotal);
        System.out.printf("Descuento aplicado: $%,.0f\n", descuento);
        System.out.printf("Total a pagar: $%,.0f\n", total);
        System.out.println("----------------------------");
        System.out.println("¡Gracias por su compra en el Reino de los Vehículos!");
    }
}
