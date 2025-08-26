package edu.dows.lab.creacional.reto_3.factory;

import edu.dows.lab.creacional.reto_3.vehiculos.*;

public abstract class VehiculoFactory {
    
    public static VehiculoFactory getFactory(String tipoVehiculo) {
        switch (tipoVehiculo.toLowerCase()) {
            case "tierra":
                return new VehiculoTierraFactory();
            case "acuatico":
                return new VehiculoAcuaticoFactory();
            case "aereo":
                return new VehiculoAereoFactory();
            default:
                throw new IllegalArgumentException("Tipo de vehículo no válido: " + tipoVehiculo);
        }
    }
    
    public abstract Vehiculo crearVehiculo(String categoria, String modelo);
    public abstract String[] getModelosDisponibles();
}
