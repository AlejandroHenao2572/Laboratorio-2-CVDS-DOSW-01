package edu.dows.lab.creacional.reto_3.vehiculos;

public class VehiculoAcuatico extends Vehiculo {
    public VehiculoAcuatico(String categoria, String modelo, double precio, int velocidadMaxima, String equipamiento) {
        super("Acuático", categoria, modelo, precio, velocidadMaxima, equipamiento);
    }
}