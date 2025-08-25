package edu.dows.lab.creacional.reto_3.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import edu.dows.lab.creacional.reto_3.compra.ComandoCompra;
import edu.dows.lab.creacional.reto_3.compra.ProcesarCompra;
import edu.dows.lab.creacional.reto_3.factory.VehiculoFactory;
import edu.dows.lab.creacional.reto_3.pagos.PagoCredito;
import edu.dows.lab.creacional.reto_3.pagos.PagoContado;
import edu.dows.lab.creacional.reto_3.pagos.TipoPago;
import edu.dows.lab.creacional.reto_3.vehiculos.Vehiculo;

public class Concesionario {
    private final Scanner scanner;
    private final List<Vehiculo> carrito;
    
    public Concesionario() {
        this.scanner = new Scanner(System.in);
        this.carrito = new ArrayList<>();
    }
    
    public void iniciarCompra() {
        System.out.println("Bienvenido al Reino de los Vehículos!");
        
        boolean continuarComprando = true;
        
        while (continuarComprando) {
            agregarVehiculo();
            continuarComprando = preguntarSiContinuar();
        }
        
        if (!carrito.isEmpty()) {
            procesarCompraFinal();
        } else {
            System.out.println("No se agregaron vehículos al carrito.");
        }
        
        scanner.close();
    }
    
    private void agregarVehiculo() {
        try {
            String tipoVehiculo = seleccionarTipoVehiculo();
            String categoria = seleccionarCategoria();
            String modelo = seleccionarModelo(tipoVehiculo);
            
            VehiculoFactory factory = VehiculoFactory.getFactory(tipoVehiculo);
            Vehiculo vehiculo = factory.crearVehiculo(categoria, modelo);
            
            carrito.add(vehiculo);
            System.out.printf("%s %s agregado al carrito!\n\n", vehiculo.getCategoria(), vehiculo.getModelo());
            
        } catch (Exception e) {
            System.out.println("Error al agregar vehículo: " + e.getMessage());
        }
    }
    
    private String seleccionarTipoVehiculo() {
        System.out.println("Seleccione el tipo de vehículo:");
        System.out.println("1. Tierra");
        System.out.println("2. Acuático");
        System.out.println("3. Aéreo");
        System.out.print("Ingrese opción: ");
        
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1: return "tierra";
            case 2: return "acuatico";
            case 3: return "aereo";
            default: throw new IllegalArgumentException("Opción no válida");
        }
    }
    
    private String seleccionarCategoria() {
        System.out.println("\nSeleccione la categoría del vehículo:");
        System.out.println("1. Económico");
        System.out.println("2. Lujo");
        System.out.println("3. Usado");
        System.out.print("Ingrese opción: ");
        
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1: return "economico";
            case 2: return "lujo";
            case 3: return "usado";
            default: throw new IllegalArgumentException("Opción no válida");
        }
    }
    
    private String seleccionarModelo(String tipoVehiculo) {
        VehiculoFactory factory = VehiculoFactory.getFactory(tipoVehiculo);
        String[] modelos = factory.getModelosDisponibles();
        
        System.out.println("\nSeleccione el modelo de vehículo:");
        for (int i = 0; i < modelos.length; i++) {
            System.out.printf("%d. %s\n", (i + 1), modelos[i]);
        }
        System.out.print("Ingrese opción: ");
        
        int opcion = scanner.nextInt();
        if (opcion >= 1 && opcion <= modelos.length) {
            return modelos[opcion - 1];
        } else {
            throw new IllegalArgumentException("Opción no válida");
        }
    }
    
    private boolean preguntarSiContinuar() {
        System.out.print("¿Desea agregar otro vehículo? (si/no): ");
        String respuesta = scanner.next().toLowerCase();
        return respuesta.equals("si") || respuesta.equals("s");
    }

    private TipoPago preguntarTipoPago() {
        System.out.print("Seleccione un metodo de pago:  \n 1.Credito \n 2.Contado \n");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1: return new PagoCredito();
            case 2: return new PagoContado();
            default: throw new IllegalArgumentException("Opción no válida");
        }
    }
    
    private void procesarCompraFinal() {
        TipoPago pago = preguntarTipoPago();
        ComandoCompra comando = new ProcesarCompra(carrito, pago);
        comando.ejecutar();
    }   
}
