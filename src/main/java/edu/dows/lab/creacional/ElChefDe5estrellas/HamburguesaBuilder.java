package edu.dows.lab.creacional.elchefde5estrellas;
import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

// Patron Builder para crear hamburguesas paso a paso
class HamburguesaBuilder {
    private Hamburguesa hamburguesa;

    public HamburguesaBuilder() {
        hamburguesa = new Hamburguesa();
    }

    public HamburguesaBuilder agregarIngrediente(Ingrediente ingrediente) {
        hamburguesa.agregarIngrediente(ingrediente);
        return this;
    }

    public Hamburguesa build() {
        return hamburguesa;
    }
}