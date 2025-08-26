package edu.dows.lab.creacional.reto_3.factory;

import edu.dows.lab.creacional.reto_3.vehiculos.*;

public class VehiculoAereoFactory extends VehiculoFactory {
    
    @Override
    public Vehiculo crearVehiculo(String categoria, String modelo) {
        switch (modelo.toLowerCase()) {
            case "avion":
                return crearAvion(categoria);
            case "avioneta":
                return crearAvioneta(categoria);
            case "helicoptero":
                return crearHelicoptero(categoria);
            default:
                throw new IllegalArgumentException("Modelo no válido: " + modelo);
        }
    }
    
    @Override
    public String[] getModelosDisponibles() {
        return new String[]{"Avión", "Avioneta", "Helicóptero"};
    }
    
    private Vehiculo crearAvion(String categoria) {
        switch (categoria.toLowerCase()) {
            case "economico":
                return new VehiculoAereo("Económico", "Avión", 200000000, 400, "Instrumentos básicos de vuelo");
            case "lujo":
                return new VehiculoAereo("Lujo", "Avión", 500000000, 500, "Piloto automático + Primera clase");
            case "usado":
                return new VehiculoAereo("Usado", "Avión", 120000000, 350, "Instrumentos estándar");
            default:
                throw new IllegalArgumentException("Categoría no válida: " + categoria);
        }
    }
    
    private Vehiculo crearAvioneta(String categoria) {
        switch (categoria.toLowerCase()) {
            case "economico":
                return new VehiculoAereo("Económico", "Avioneta", 150000000, 250, "Instrumentos básicos de vuelo");
            case "lujo":
                return new VehiculoAereo("Lujo", "Avioneta", 300000000, 300, "GPS + Piloto automático");
            case "usado":
                return new VehiculoAereo("Usado", "Avioneta", 100000000, 200, "Instrumentos básicos");
            default:
                throw new IllegalArgumentException("Categoría no válida: " + categoria);
        }
    }
    
    private Vehiculo crearHelicoptero(String categoria) {
        switch (categoria.toLowerCase()) {
            case "economico":
                return new VehiculoAereo("Económico", "Helicóptero", 180000000, 200, "Instrumentos básicos");
            case "lujo":
                return new VehiculoAereo("Lujo", "Helicóptero", 400000000, 250, "GPS + Cabina VIP");
            case "usado":
                return new VehiculoAereo("Usado", "Helicóptero", 120000000, 180, "Instrumentos estándar");
            default:
                throw new IllegalArgumentException("Categoría no válida: " + categoria);
        }
    }
}