package edu.dows.lab.comportamiento.tienda.modelo;

import edu.dows.lab.comportamiento.tienda.descuentos.EstrategiaDescuento;

public class Cliente {
    private final EstrategiaDescuento estrategiaDescuento;
    
    public Cliente(EstrategiaDescuento estrategiaDescuento) {
        if (estrategiaDescuento == null) {
            throw new IllegalArgumentException("La estrategia de descuento no puede ser nula");
        }
        this.estrategiaDescuento = estrategiaDescuento;
    }
    
    public double aplicarDescuento(double subtotal) {
        if (subtotal < 0) {
            throw new IllegalArgumentException("El subtotal no puede ser negativo");
        }
        return estrategiaDescuento.aplicarDescuento(subtotal);
    }
    
    public String getTipoCliente() {
        return estrategiaDescuento.getTipoCliente();
    }
    
    public double getPorcentajeDescuento() {
        return estrategiaDescuento.getPorcentajeDescuento();
    }
}