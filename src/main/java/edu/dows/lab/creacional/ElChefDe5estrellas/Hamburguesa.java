package edu.dows.lab.creacional.elchefde5estrellas;
// package declaration removed to match default package
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;


class Hamburguesa {
    private List<Ingrediente> ingredientes;

    public Hamburguesa() {
        this.ingredientes = new ArrayList<>();
    }

    public void agregarIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public int calcularPrecioTotal() {
        return ingredientes.stream()
                .mapToInt(Ingrediente::getPrecio)
                .sum();
    }
    public void mostrarHamburguesa() {
        System.out.println("--- HAMBURGUESA PERSONALIZADA --");
        System.out.print("Ingredientes seleccionados: ");
        String listaIngredientes = ingredientes.stream()
                .map(Ingrediente::getNombre)
                .collect(Collectors.joining(", "));
        System.out.println(listaIngredientes);
        System.out.println("Precio total: $" + String.format("%,d", calcularPrecioTotal()));
        System.out.println("¡Disfrute su hamburguesa!");
    }
}

