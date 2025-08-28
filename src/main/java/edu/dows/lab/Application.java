package edu.dows.lab;
import edu.dows.lab.comportamiento.reto_1.main.TiendaDonPepe;
import edu.dows.lab.creacional.reto_2.RetoChefHamburguesa;
import edu.dows.lab.estructural.reto_5.CafePersonalizadoApp;
import edu.dows.lab.creacional.reto_3.main.ReinoVehiculos;
import edu.dows.lab.creacional.reto_4.CasaDeCambio;
import edu.dows.lab.comportamiento.reto_6.main.SistemaSoporte;
import edu.dows.lab.comportamiento.reto_7.app.ControlRemoto;

public class Application {
    public static void main(String[] args) {
        System.out.println("Proyecto Maven configurado y corriendo correctamente\n");
        
        //llamada a reto 1
        System.err.println("RETO #1-Tienda don Pepe:\n");
        TiendaDonPepe.run();

        //llamada a reto 2
        System.err.println("\nRETO #2-El Chef de 5 estrellas:\n");
        RetoChefHamburguesa.run();

        //llamada a reto 3
        System.err.println("\nRETO #3-Concesionario:\n");
        ReinoVehiculos.run();

        //llamada a reto 4
        System.err.println("\nRETO #4-Casa de Cambio:\n");
        CasaDeCambio.run();

        //llamada a reto 5
        System.err.println("\nRETO #5-Café Personalizado:\n");
        CafePersonalizadoApp.run();

        //llamada a reto 6
        System.err.println("\nRETO #6-Sistema de Soporte:\n");
        SistemaSoporte.run();

        //llamada a reto 7
        System.err.println("\nRETO #7-Control Remoto:\n");
        ControlRemoto.run();
    }
}