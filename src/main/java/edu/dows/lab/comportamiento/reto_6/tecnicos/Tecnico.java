package edu.dows.lab.comportamiento.reto_6.tecnicos;

import edu.dows.lab.comportamiento.reto_6.modelo.Ticket;
import edu.dows.lab.comportamiento.reto_6.cadena.ResultadoProcesamiento;

public abstract class Tecnico {
    protected Tecnico siguienteTecnico;
    protected final String tipo;
    
    public Tecnico(String tipo) {
        this.tipo = tipo;
    }
    
    public void setSiguienteTecnico(Tecnico siguiente) {
        this.siguienteTecnico = siguiente;
    }
    
    public ResultadoProcesamiento procesarTicket(Ticket ticket) {
        if (puedeResolver(ticket)) {
            return new ResultadoProcesamiento(ticket, this, true);
        }
        
        if (siguienteTecnico != null) {
            return siguienteTecnico.procesarTicket(ticket);
        }
        
        return new ResultadoProcesamiento(ticket, null, false);
    }
    
    protected abstract boolean puedeResolver(Ticket ticket);
    
    public String getTipo() { return tipo; }
    
    @Override
    public String toString() { return tipo; }
}