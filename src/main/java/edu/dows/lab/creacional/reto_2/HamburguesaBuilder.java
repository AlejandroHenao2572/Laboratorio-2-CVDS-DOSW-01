package edu.dows.lab.creacional.reto_2;


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