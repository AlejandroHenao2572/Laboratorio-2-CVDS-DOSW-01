package edu.dows.lab.estructural.cafePerzonalizado;

import java.util.*;
public class CafePersonalizadoApp {
    public static void run() {
        InterfazUsuario interfaz = new InterfazUsuario();
        ToppingManager toppingManager = new ToppingManager();
        ConstruirCafe constructor = new ConstruirCafe(toppingManager, interfaz);

        int numCafes = interfaz.solicitarNumeroCafes();
        List<Cafe> cafes = new ArrayList<>();

        for (int i = 1; i <= numCafes; i++) {
            System.out.printf("Café %d:\n", i);
            Cafe cafe = constructor.crearCafe();
            cafes.add(cafe);
        }

        interfaz.mostrarResumen(cafes);
    }
}