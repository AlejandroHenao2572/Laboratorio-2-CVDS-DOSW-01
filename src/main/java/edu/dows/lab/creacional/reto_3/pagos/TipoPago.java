package edu.dows.lab.creacional.reto_3.pagos;

public interface TipoPago {
    double calcularDescuento(double subtotal);
    String getTipoPago();
}
