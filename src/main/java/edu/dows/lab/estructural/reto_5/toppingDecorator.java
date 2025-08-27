package edu.dows.lab.estructural.reto_5;
abstract class ToppingDecorator implements Cafe {
    protected Cafe cafe;

    public ToppingDecorator(Cafe cafe) {
        this.cafe = cafe;
    }
}