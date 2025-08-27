package edu.dows.lab.estructural.cafePerzonalizado;

import java.util.*;

class InterfazUsuario {
    Scanner sc = new Scanner(System.in);
 
    public int solicitarNumeroCafes() {
        System.out.print("Número de cafés a personalizar: ");
        return sc.nextInt();
    }
 
    public List<Integer> solicitarToppingsDisponibles(ToppingManager tm) {
        tm.mostrarToppings();
        System.out.print("Seleccione toppings (números separados por coma): ");
        sc.nextLine(); // limpiar buffer
        String input = sc.nextLine();
        String[] tokens = input.split(",");
        List<Integer> opciones = new ArrayList<>();
        for (String t : tokens) {
            try {
                opciones.add(Integer.parseInt(t.trim()));
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, se ignora: " + t);
            }
        }
        return opciones;
    }
 
    public String solicitarNuevoToppingNombre() {
        System.out.print("Ingrese nombre del nuevo topping: ");
        return sc.nextLine();
    }
 
    public double solicitarNuevoToppingPrecio() {
        System.out.print("Ingrese precio del topping: ");
        return sc.nextDouble();
    }
 
    public void mostrarResumen(List<Cafe> cafes) {
        System.out.println("\nRESUMEN DE CAFÉ PERSONALIZADO");
        for (int i = 0; i < cafes.size(); i++) {
            Cafe c = cafes.get(i);
            System.out.printf("Café %d:\n", i + 1);
            System.out.println("Ingredientes: " + c.getDescripcion());
            System.out.printf("Precio total: $%.0f\n", c.getPrecio());
        }
        double totalGeneral = cafes.stream().mapToDouble(Cafe::getPrecio).sum();
        System.out.printf("Total a pagar por todos los cafés: $%.0f\n", totalGeneral);
        System.out.println("¡Disfrute su café!");
    }
}