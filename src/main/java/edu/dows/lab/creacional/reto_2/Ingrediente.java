package edu.dows.lab.creacional.reto_2;


public class Ingrediente {
    private String nombre;
    private int precio; 

    public Ingrediente(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return nombre + " ($" + String.format("%,d", precio) + ")";
    }
}