package edu.dows.lab.creacional.elchefde5estrellas;

import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;


public class Ingrediente {
    private String nombre;
    private int precio; // precio en pesos, sin formato

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