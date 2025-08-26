package edu.dows.lab;
import edu.dows.lab.comportamiento.reto_1.main.TiendaDonPepe;
import edu.dows.lab.creacional.elChefDe5estrellas.RetoChefHamburguesa;
import edu.dows.lab.estructural.cafePerzonalizado.CafePersonalizadoApp;
import edu.dows.lab.creacional.reto_3.main.ReinoVehiculos;
import edu.dows.lab.comportamiento.reto_6.main.SistemaSoporte;

public class Application {
    public static void main(String[] args) {
        System.out.println("Proyecto Maven configurado y corriendo correctamente\n");
        
        //llamada a reto 1
        System.err.println("RETO #1-Tienda don Pepe:\n");
        TiendaDonPepe.run();

        //llamada a reto 2
        System.err.println("RETO #2-Café Personalizado:\n");
        CafePersonalizadoApp.run();

        //llamada a reto 3
        System.err.println("RETO #3-Concesionario:\n");
        ReinoVehiculos.run();

        //llamada a reto 5
        System.err.println("RETO #5-El Chef de 5 estrellas:\n");
        RetoChefHamburguesa.run();

        //llamada a reto 6
        System.err.println("RETO #6-Sistema de Soporte:\n");
        SistemaSoporte.run();
    }
}
