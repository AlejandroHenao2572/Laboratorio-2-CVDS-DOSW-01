package edu.dows.lab.comportamiento.reto_1.servicios;

import edu.dows.lab.comportamiento.reto_1.modelo.Cliente;
import edu.dows.lab.comportamiento.reto_1.descuentos.DescuentoClienteNuevo;
import edu.dows.lab.comportamiento.reto_1.descuentos.DescuentoClienteFrecuente;

public class ClienteFactory {
    
    public static Cliente crearCliente(String tipoCliente) {
             
        switch (tipoCliente.toLowerCase().trim()) {
            case "nuevo":
                return new Cliente(new DescuentoClienteNuevo());
            case "frecuente":
                return new Cliente(new DescuentoClienteFrecuente());
            default:
                throw new IllegalArgumentException(
                    String.format("Tipo de cliente no valido: '%s'. " +
                                "Tipos validos: 'nuevo', 'frecuente'", tipoCliente));
        }
    }
    
    public static String[] getTiposClienteDisponibles() {
        return new String[]{"nuevo", "frecuente"};
    }
}