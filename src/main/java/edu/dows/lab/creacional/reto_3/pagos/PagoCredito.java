package edu.dows.lab.creacional.reto_3.pagos;

public class PagoCredito implements TipoPago {

    @Override
    public double calcularDescuento(double subtotal) {
        return 0; // Sin descuento para credito
    }
    
    @Override
    public String getTipoPago() {
        return "Crédito";
    }
}
