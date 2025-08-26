package edu.dows.lab.comportamiento.reto_6.modelo;

public enum NivelDificultad {
    BASICO("basico"),
    INTERMEDIO("intermedio"),
    AVANZADO("avanzado");
    
    private final String descripcion;
    
    NivelDificultad(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion() { return descripcion; }
    
    public static NivelDificultad fromString(String texto) {
        for (NivelDificultad nivel : values()) {
            if (nivel.descripcion.equalsIgnoreCase(texto.trim())) {
                return nivel;
            }
        }
        throw new IllegalArgumentException("Nivel de dificultad no válido: " + texto);
    }
    
    @Override
    public String toString() { return descripcion; }
}