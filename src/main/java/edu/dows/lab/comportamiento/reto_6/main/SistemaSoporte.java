package edu.dows.lab.comportamiento.reto_6.main;

import edu.dows.lab.comportamiento.reto_6.modelo.*;
import edu.dows.lab.comportamiento.reto_6.tecnicos.Tecnico;
import edu.dows.lab.comportamiento.reto_6.cadena.CadenaResponsabilidadFactory;
import edu.dows.lab.comportamiento.reto_6.comandos.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaSoporte {
    private final Scanner scanner;
    private final List<Ticket> tickets;
    
    public SistemaSoporte() {
        this.scanner = new Scanner(System.in);
        this.tickets = new ArrayList<>();
    }
    
    public static void run() {
        SistemaSoporte sistema = new SistemaSoporte();
        sistema.ejecutar();
    }
    
    public void ejecutar() {
        System.out.println("=== SISTEMA DE SOPORTE TÉCNICO ===");
        
        try {
            recolectarTickets();
            procesarTickets();
        } catch (Exception e) {
            System.err.println("Error en el sistema: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    
    private void recolectarTickets() {
        System.out.print("Número de tickets: ");
        int numeroTickets = scanner.nextInt();
        scanner.nextLine(); 
        
        for (int i = 1; i <= numeroTickets; i++) {
            System.out.println("\nTicket " + i + ":");
            
            try {
                String nivel = solicitarDato("Nivel (básico/intermedio/avanzado): ");
                String prioridad = solicitarDato("Prioridad (baja/media/alta): ");
                String descripcion = solicitarDato("Descripción: ");
                
                Ticket ticket = new Ticket(
                    i,
                    descripcion,
                    NivelDificultad.fromString(nivel.toLowerCase()),
                    Prioridad.fromString(prioridad.toLowerCase())
                );
                
                tickets.add(ticket);
                System.out.println("Ticket creado exitosamente");
                
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
                i--; // Repetir este ticket
            }
        }
    }
    
    private String solicitarDato(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        
        if (input.isEmpty()) {
            throw new IllegalArgumentException("El campo no puede estar vacío");
        }
        
        return input;
    }
    
    private void procesarTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No hay tickets para procesar.");
            return;
        }
        
        // Crear la cadena de responsabilidad usando Factory
        Tecnico cadenaCompleta = CadenaResponsabilidadFactory.crearCadenaCompleta();
        
        // Crear y ejecutar el comando de procesamiento
        ComandoProcesamiento comando = new ProcesarTicketsComando(tickets, cadenaCompleta);
        comando.ejecutar();
    }
}