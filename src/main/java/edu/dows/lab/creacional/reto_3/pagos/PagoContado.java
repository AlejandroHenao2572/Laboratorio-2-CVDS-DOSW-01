package edu.dows.lab.creacionales.reto_3.pagos;

public class PagoContado implements TipoPago {
    
    @Override
    public double calcularDescuento(double subtotal) {
        return subtotal * 0.05; // 5% descuento por pago de contado
    }
    
    @Override
    public String getTipoPago() {
        return "Contado";
    }
}
