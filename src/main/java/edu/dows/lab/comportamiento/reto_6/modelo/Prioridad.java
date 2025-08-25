package edu.dows.lab.comportamiento.reto_6.modelo;

public enum Prioridad {
    BAJA(1, "baja"),
    MEDIA(2, "media"), 
    ALTA(3, "alta");
    
    private final int valor;
    private final String descripcion;
    
    Prioridad(int valor, String descripcion) {
        this.valor = valor;
        this.descripcion = descripcion;
    }
    
    public int getValor() { return valor; }
    public String getDescripcion() { return descripcion; }
    
    public static Prioridad fromString(String texto) {
        for (Prioridad p : values()) {
            if (p.descripcion.equalsIgnoreCase(texto.trim())) {
                return p;
            }
        }
        throw new IllegalArgumentException("Prioridad no válida: " + texto);
    }
    
    @Override
    public String toString() { return descripcion; }
}