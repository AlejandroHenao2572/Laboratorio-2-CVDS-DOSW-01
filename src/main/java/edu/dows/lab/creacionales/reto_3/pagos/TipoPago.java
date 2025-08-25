package edu.dows.lab.creacionales.reto_3.pagos;

public interface TipoPago {
    double calcularDescuento(double subtotal);
    String getTipoPago();
}
