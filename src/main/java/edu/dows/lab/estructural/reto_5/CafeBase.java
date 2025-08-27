package edu.dows.lab.estructural.reto_5;

public class CafeBase implements Cafe {
    @Override
    public String getDescripcion() {
        return "Café base";
    }

    @Override
    public double getPrecio() {
        return 3000; // precio base fijo
    }
}


