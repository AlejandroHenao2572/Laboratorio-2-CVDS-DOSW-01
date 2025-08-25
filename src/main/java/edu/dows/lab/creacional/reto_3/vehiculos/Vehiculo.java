package edu.dows.lab.creacional.reto_3.vehiculos;

public abstract class Vehiculo {
    protected final String tipo;
    protected final String categoria;
    protected final String modelo;
    protected final double precio;
    protected final int velocidadMaxima;
    protected final String equipamiento;
    
    public Vehiculo(String tipo, String categoria, String modelo, 
                   double precio, int velocidadMaxima, String equipamiento) {
        this.tipo = tipo;
        this.categoria = categoria;
        this.modelo = modelo;
        this.precio = precio;
        this.velocidadMaxima = velocidadMaxima;
        this.equipamiento = equipamiento;
    }
    
    // Getters
    public String getTipo() { return tipo; }
    public String getCategoria() { return categoria; }
    public String getModelo() { return modelo; }
    public double getPrecio() { return precio; }
    public int getVelocidadMaxima() { return velocidadMaxima; }
    public String getEquipamiento() { return equipamiento; }
    
    @Override
    public String toString() {
        return String.format("Tipo: %s\nCategoría: %s\nVelocidad máxima: %d km/h\n" +
                           "Precio: $%,.0f\nEquipamiento: %s",
                           modelo, categoria, velocidadMaxima, precio, equipamiento);
    }
}