package edu.dows.lab.comportamiento.tienda.descuentos;

public class DescuentoClienteNuevo implements EstrategiaDescuento {
    private static final double PORCENTAJE_DESCUENTO = 0.05; // 5%
    private static final String TIPO_CLIENTE = "Nuevo";
    
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