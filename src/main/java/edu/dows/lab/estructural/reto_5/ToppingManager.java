package edu.dows.lab.estructural.cafePerzonalizado;

import java.util.*;

public class ToppingManager {
    private Map<Integer, String> nombres = new HashMap<>();
    private Map<Integer, Double> precios = new HashMap<>();
    private int siguienteId;

    public ToppingManager() {
        // Cargar toppings iniciales predefinidos
        agregarTopping("Leche", 1000d);
        agregarTopping("Chocolate", 1500d);
        agregarTopping("Caramelo", 1200d);
        agregarTopping("Crema Batida", 2000d);
        agregarTopping("Menta", 1300d);
    }

    public void agregarTopping(String nombre, double precio) {
        nombres.put(siguienteId, nombre);
        precios.put(siguienteId, precio);
        siguienteId++;
    }

    public String obtenerNombre(int id) {
        return nombres.get(id);
    }

    public double obtenerPrecio(int id) {
        return precios.get(id);
    }

    public void mostrarToppings() {
        System.out.println("Lista de toppings disponibles:");
        nombres.forEach((id, nombre) -> {
            System.out.printf("%d. %s - $%.0f\n", id + 1, nombre, precios.get(id));
        });
        System.out.printf("%d. Agregar nuevo topping\n", siguienteId + 1);
    }

    public int obtenerSiguienteId() {
        return siguienteId;
    }
}
