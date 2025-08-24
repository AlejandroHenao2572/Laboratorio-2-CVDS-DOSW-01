package edu.dows.lab.comportamiento.reto_1.descuentos;

public interface EstrategiaDescuento {
    /**
     * Aplica el descuento correspondiente al subtotal
     * @param subtotal el subtotal antes del descuento
     * @return el monto del descuento a aplicar
     */
    double aplicarDescuento(double subtotal);
    
    /**
     * Obtiene el porcentaje de descuento como decimal (ej: 0.05 para 5%)
     * @return el porcentaje de descuento
     */
    double getPorcentajeDescuento();
    
    /**
     * Obtiene el tipo de cliente como string
     * @return el tipo de cliente
     */
    String getTipoCliente();
}