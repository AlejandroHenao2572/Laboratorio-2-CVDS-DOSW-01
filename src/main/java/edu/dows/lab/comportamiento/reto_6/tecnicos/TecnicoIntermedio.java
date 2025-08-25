package edu.dows.lab.comportamiento.reto_6.tecnicos;

import edu.dows.lab.comportamiento.reto_6.modelo.Ticket;
import edu.dows.lab.comportamiento.reto_6.modelo.NivelDificultad;

public class TecnicoIntermedio extends Tecnico {
    
    public TecnicoIntermedio() {
        super("Técnico Intermedio");
    }
    
    @Override
    protected boolean puedeResolver(Ticket ticket) {
        return ticket.getNivel() == NivelDificultad.INTERMEDIO;
    }
}