package edu.dows.lab.creacional.reto_3.factory;

import edu.dows.lab.creacional.reto_3.vehiculos.*;

public class VehiculoAcuaticoFactory extends VehiculoFactory {
    
    @Override
    public Vehiculo crearVehiculo(String categoria, String modelo) {
        switch (modelo.toLowerCase()) {
            case "lancha":
                return crearLancha(categoria);
            case "velero":
                return crearVelero(categoria);
            case "jetski":
                return crearJetSki(categoria);
            default:
                throw new IllegalArgumentException("Modelo no válido: " + modelo);
        }
    }
    
    @Override
    public String[] getModelosDisponibles() {
        return new String[]{"Lancha", "Velero", "Jet Ski"};
    }
    
    private Vehiculo crearLancha(String categoria) {
        switch (categoria.toLowerCase()) {
            case "economico":
                return new VehiculoAcuatico("Económico", "Lancha", 30000000, 60, "Motor básico");
            case "lujo":
                return new VehiculoAcuatico("Lujo", "Lancha", 80000000, 90, "GPS + Sonar + Cabina");
            case "usado":
                return new VehiculoAcuatico("Usado", "Lancha", 20000000, 50, "Motor estándar");
            default:
                throw new IllegalArgumentException("Categoría no válida: " + categoria);
        }
    }
    
    private Vehiculo crearVelero(String categoria) {
        switch (categoria.toLowerCase()) {
            case "economico":
                return new VehiculoAcuatico("Económico", "Velero", 25000000, 20, "Velas básicas");
            case "lujo":
                return new VehiculoAcuatico("Lujo", "Velero", 60000000, 25, "Velas automáticas + GPS");
            case "usado":
                return new VehiculoAcuatico("Usado", "Velero", 15000000, 18, "Velas estándar");
            default:
                throw new IllegalArgumentException("Categoría no válida: " + categoria);
        }
    }
    
    private Vehiculo crearJetSki(String categoria) {
        switch (categoria.toLowerCase()) {
            case "economico":
                return new VehiculoAcuatico("Económico", "Jet Ski", 15000000, 70, "Motor básico");
            case "lujo":
                return new VehiculoAcuatico("Lujo", "Jet Ski", 35000000, 100, "Motor turbo + GPS");
            case "usado":
                return new VehiculoAcuatico("Usado", "Jet Ski", 10000000, 60, "Motor estándar");
            default:
                throw new IllegalArgumentException("Categoría no válida: " + categoria);
        }
    }
}