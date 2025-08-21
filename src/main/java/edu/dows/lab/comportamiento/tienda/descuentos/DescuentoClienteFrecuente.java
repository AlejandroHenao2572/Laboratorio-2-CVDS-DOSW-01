package edu.dows.lab.comportamiento.tienda.descuentos;

public class DescuentoClienteFrecuente implements EstrategiaDescuento {
    private static final double PORCENTAJE_DESCUENTO = 0.10; // 10%
    private static final String TIPO_CLIENTE = "Frecuente";
    
    @Override
    public double aplicarDescuento(double subtotal) {
        return subtotal * PORCENTAJE_DESCUENTO;
    }
    
    @Override
    public double getPorcentajeDescuento() {
        return PORCENTAJE_DESCUENTO;
    }
    
    @Override
    public String getTipoCliente() {
        return TIPO_CLIENTE;
    }
}