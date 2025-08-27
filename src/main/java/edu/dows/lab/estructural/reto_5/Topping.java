package edu.dows.lab.estructural.cafePerzonalizado;
public class Topping extends ToppingDecorator {
    private String descripcion;
    private double precio;

    public Topping(Cafe cafe, String descripcion, double precio) {
        super(cafe);
        this.descripcion = descripcion;
        this.precio = precio;
    }

    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + " + " + descripcion;
    }

    @Override
    public double getPrecio() {
        return cafe.getPrecio() + precio;
    }
}
