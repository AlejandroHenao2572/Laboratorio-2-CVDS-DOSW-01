package edu.dows.lab.comportamiento.reto_6.cadena;

import edu.dows.lab.comportamiento.reto_6.modelo.Ticket;
import edu.dows.lab.comportamiento.reto_6.tecnicos.Tecnico;

public class ResultadoProcesamiento {
    private final Ticket ticket;
    private final Tecnico tecnicoQueResolvio;
    private final boolean resuelto;
    
    public ResultadoProcesamiento(Ticket ticket, Tecnico tecnicoQueResolvio, boolean resuelto) {
        this.ticket = ticket;
        this.tecnicoQueResolvio = tecnicoQueResolvio;
        this.resuelto = resuelto;
    }
    
    // Getters
    public Ticket getTicket() { return ticket; }
    public Tecnico getTecnicoQueResolvio() { return tecnicoQueResolvio; }
    public boolean fueResuelto() { return resuelto; }
    
    public String getMensajeResultado() {
        if (resuelto) {
            return String.format("Ticket %d: %s resolvio el problema.", 
                               ticket.getId(), tecnicoQueResolvio.getTipo());
        } else {
            return String.format("Ticket %d: Ningún tecnico disponible. Ticket pendiente de escalamiento.", 
                               ticket.getId());
        }
    }
}