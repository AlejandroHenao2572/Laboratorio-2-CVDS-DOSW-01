package edu.dows.lab.comportamiento.reto_6.modelo;

public class Ticket {
    private final int id;
    private final String descripcion;
    private final NivelDificultad nivel;
    private final Prioridad prioridad;
    
    public Ticket(int id, String descripcion, NivelDificultad nivel, Prioridad prioridad) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía");
        }
        
        this.id = id;
        this.descripcion = descripcion.trim();
        this.nivel = nivel;
        this.prioridad = prioridad;
    }
    
    // Getters
    public int getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public NivelDificultad getNivel() { return nivel; }
    public Prioridad getPrioridad() { return prioridad; }
    
    @Override
    public String toString() {
        return String.format("Ticket %d: %s [%s - %s]", 
                           id, descripcion, nivel, prioridad);
    }
}