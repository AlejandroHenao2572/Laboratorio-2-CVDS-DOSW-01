package edu.dows.lab.creacional.elchefde5estrellas;

import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class RetoChefHamburguesa {
    private static final Scanner scanner = new Scanner(System.in);

    private static List<Ingrediente> ingredientesDisponibles = new ArrayList<>(Arrays.asList(
            new Ingrediente("Pan", 3000),
            new Ingrediente("Carne", 10000),
            new Ingrediente("Queso", 5000),
            new Ingrediente("Lechuga", 2000),
            new Ingrediente("Tomate", 2000),
            new Ingrediente("Salsa especial", 3000)
    ));

    public static void main(String[] args) {
        System.out.println("Seleccione ingredientes para su hamburguesa:");
        mostrarIngredientes();

        System.out.print("Ingrese los números separados por coma: ");
        String linea = scanner.nextLine();
        String[] seleccion = linea.split(",");
        Set<Integer> numerosSeleccionados = new LinkedHashSet<>();
        for (String s : seleccion) {
            try {
                int num = Integer.parseInt(s.trim());
                if (num >= 1 && num <= ingredientesDisponibles.size() + 1) {
                    numerosSeleccionados.add(num);
                } else {
                    System.out.println("Número fuera de rango ignorado: " + num);
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida ignorada: " + s);
            }
        }

        // Si el usuario eligió la opción 'Agregar nuevo ingrediente' (que está en la posición ingredientesDisponibles.size()+1)
        if (numerosSeleccionados.contains(ingredientesDisponibles.size() + 1)) {
            agregarNuevoIngrediente();
            // Remove la opcion '7' o última para que no se intente agregar dos veces
            numerosSeleccionados.remove(ingredientesDisponibles.size() + 1);
        }

        HamburguesaBuilder builder = new HamburguesaBuilder();
        for (int num : numerosSeleccionados) {
            Ingrediente ing = ingredientesDisponibles.get(num - 1);
            builder.agregarIngrediente(ing);
        }

        Hamburguesa hamburguesa = builder.build();
        hamburguesa.mostrarHamburguesa();
    }

    private static void mostrarIngredientes() {
        for (int i = 0; i < ingredientesDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + ingredientesDisponibles.get(i).toString());
        }
        System.out.println((ingredientesDisponibles.size() + 1) + ". Agregar un nuevo ingrediente");
    }

    private static void agregarNuevoIngrediente() {
        System.out.print("Ingrese el nombre del nuevo ingrediente: ");
        String nombre = scanner.nextLine().trim();
        int precio = 0;
        while (true) {
            System.out.print("Ingrese el precio del ingrediente (sin puntos ni comas): ");
            String precioStr = scanner.nextLine().replace(".", "").replace(",", "");
            try {
                precio = Integer.parseInt(precioStr);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Precio inválido. Intente de nuevo.");
            }
        }
        Ingrediente nuevo = new Ingrediente(nombre, precio);
        ingredientesDisponibles.add(nuevo);
        System.out.println("Nuevo ingrediente agregado: " + nuevo);
    }
}