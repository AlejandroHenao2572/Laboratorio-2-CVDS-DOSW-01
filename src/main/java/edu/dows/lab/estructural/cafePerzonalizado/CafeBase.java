package main.java.edu.dows.lab.estructural.cafePerzonalizado;
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


