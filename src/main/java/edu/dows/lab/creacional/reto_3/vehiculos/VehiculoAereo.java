package edu.dows.lab.creacional.reto_3.vehiculos;

public class VehiculoAereo extends Vehiculo {
    public VehiculoAereo(String categoria, String modelo, double precio, int velocidadMaxima, String equipamiento) {
        super("Aéreo", categoria, modelo, precio, velocidadMaxima, equipamiento);
    }
}