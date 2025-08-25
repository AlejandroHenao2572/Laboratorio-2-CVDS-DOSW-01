package edu.dows.lab.comportamiento.reto_6.comandos;

import edu.dows.lab.comportamiento.reto_6.modelo.Ticket;
import edu.dows.lab.comportamiento.reto_6.tecnicos.Tecnico;
import edu.dows.lab.comportamiento.reto_6.cadena.ResultadoProcesamiento;
import edu.dows.lab.comportamiento.reto_6.estadisticas.GeneradorEstadisticas;
import java.util.List;
import java.util.stream.Collectors;

public class ProcesarTicketsComando implements ComandoProcesamiento {
    private final List<Ticket> tickets;
    private final Tecnico cadenaInicial;
    private final GeneradorEstadisticas generadorEstadisticas;
    
    public ProcesarTicketsComando(List<Ticket> tickets, Tecnico cadenaInicial) {
        this.tickets = tickets;
        this.cadenaInicial = cadenaInicial;
        this.generadorEstadisticas = new GeneradorEstadisticas();
    }
    
    @Override
    public void ejecutar() {
        if (tickets.isEmpty()) {
            System.out.println("No hay tickets para procesar.");
            return;
        }
        
        // Procesar todos los tickets usando streams
        List<ResultadoProcesamiento> resultados = tickets.stream()
            .map(ticket -> cadenaInicial.procesarTicket(ticket))
            .collect(Collectors.toList());
        
        // Mostrar resultados
        mostrarResultados(resultados);
        
        // Generar estadísticas
        generadorEstadisticas.generarEstadisticas(resultados);
    }
    
    private void mostrarResultados(List<ResultadoProcesamiento> resultados) {
        System.out.println("\n=== RESULTADOS DEL PROCESAMIENTO ===");
        resultados.forEach(resultado -> 
            System.out.println(resultado.getMensajeResultado())
        );
    }
}