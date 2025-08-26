package edu.dows.lab.comportamiento.reto_6.tecnicos;

import edu.dows.lab.comportamiento.reto_6.modelo.Ticket;

public class TecnicoAvanzado extends Tecnico {
    
    public TecnicoAvanzado() {
        super("Técnico Avanzado");
    }
    
    @Override
    protected boolean puedeResolver(Ticket ticket) {
        return ticket.getNivel() == edu.dows.lab.comportamiento.reto_6.modelo.NivelDificultad.AVANZADO;
    }
}