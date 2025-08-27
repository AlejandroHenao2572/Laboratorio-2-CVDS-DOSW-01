package edu.dows.lab.comportamiento.reto_6.estadisticas;

import edu.dows.lab.comportamiento.reto_6.cadena.ResultadoProcesamiento;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class GeneradorEstadisticas {
    
    public void generarEstadisticas(List<ResultadoProcesamiento> resultados) {
        if (resultados.isEmpty()) {
            System.out.println("No hay resultados para generar estadísticas.");
            return;
        }
        
        System.out.println("\n-- Estadísticas --");
        
        // Tickets resueltos por tipo de técnico usando streams
        Map<String, Long> ticketsPorTecnico = resultados.stream()
            .filter(ResultadoProcesamiento::fueResuelto)
            .collect(Collectors.groupingBy(
                r -> r.getTecnicoQueResolvio().getTipo(),
                Collectors.counting()
            ));
        
        System.out.println("Tickets resueltos:");
        System.out.println("Básico: " + ticketsPorTecnico.getOrDefault("Técnico Básico", 0L));
        System.out.println("Intermedio: " + ticketsPorTecnico.getOrDefault("Técnico Intermedio", 0L));
        System.out.println("Avanzado: " + ticketsPorTecnico.getOrDefault("Técnico Avanzado", 0L));
        
        // Contar tickets pendientes
        long pendientes = resultados.stream()
            .filter(r -> !r.fueResuelto())
            .count();
        System.out.println("Tickets pendientes: " + pendientes);
        
        // Promedio de prioridad de tickets resueltos
        OptionalDouble promediorPrioridad = resultados.stream()
            .filter(ResultadoProcesamiento::fueResuelto)
            .mapToInt(r -> r.getTicket().getPrioridad().getValor())
            .average();
        
        if (promediorPrioridad.isPresent()) {
            System.out.printf("Promedio de prioridad de tickets resueltos: %.1f\n", 
                            promediorPrioridad.getAsDouble());
        } else {
            System.out.println("No hay tickets resueltos para calcular promedio de prioridad.");
        }
    }
}