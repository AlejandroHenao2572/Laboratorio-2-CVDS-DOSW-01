package edu.dows.lab.creacionales.reto_3.factory;


import edu.dows.lab.creacionales.reto_3.vehiculos.*;


public class VehiculoTierraFactory extends VehiculoFactory {
    
    @Override
    public Vehiculo crearVehiculo(String categoria, String modelo) {
        switch (modelo.toLowerCase()) {
            case "auto":
                return crearAuto(categoria);
            case "bicicleta":
                return crearBicicleta(categoria);
            case "moto":
                return crearMoto(categoria);
            default:
                throw new IllegalArgumentException("Modelo no valido: " + modelo);
        }
    }
    
    @Override
    public String[] getModelosDisponibles() {
        return new String[]{"Auto", "Bicicleta", "Moto"};
    }
    
    private Vehiculo crearAuto(String categoria) {
        switch (categoria.toLowerCase()) {
            case "economico":
                return new VehiculoTierra("Economico", "Auto", 25000000, 140, "Radio basico");
            case "lujo":
                return new VehiculoTierra("Lujo", "Auto", 50000000, 180, "Aire acondicionado + GPS");
            case "usado":
                return new VehiculoTierra("Usado", "Auto", 15000000, 120, "Radio");
            default:
                throw new IllegalArgumentException("Categoría no valida: " + categoria);
        }
    }
    
    private Vehiculo crearBicicleta(String categoria) {
        switch (categoria.toLowerCase()) {
            case "economico":
                return new VehiculoTierra("Economico", "Bicicleta", 500000, 25, "Frenos basicos");
            case "lujo":
                return new VehiculoTierra("Lujo", "Bicicleta", 2000000, 30, "Cambios + Suspension");
            case "usado":
                return new VehiculoTierra("Usado", "Bicicleta", 200000, 20, "Basico");
            default:
                throw new IllegalArgumentException("Categoría no valida: " + categoria);
        }
    }
    
    private Vehiculo crearMoto(String categoria) {
        switch (categoria.toLowerCase()) {
            case "economico":
                return new VehiculoTierra("Economico", "Moto", 8000000, 80, "Frenos basicos");
            case "lujo":
                return new VehiculoTierra("Lujo", "Moto", 20000000, 120, "ABS + GPS");
            case "usado":
                return new VehiculoTierra("Usado", "Moto", 5000000, 70, "Básico");
            default:
                throw new IllegalArgumentException("Categoría no válida: " + categoria);
        }
    }
}