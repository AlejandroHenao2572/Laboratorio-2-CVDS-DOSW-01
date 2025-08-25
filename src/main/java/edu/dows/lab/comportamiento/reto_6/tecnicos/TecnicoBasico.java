package edu.dows.lab.comportamiento.reto_6.tecnicos;

import edu.dows.lab.comportamiento.reto_6.modelo.Ticket;
import edu.dows.lab.comportamiento.reto_6.modelo.NivelDificultad;
import edu.dows.lab.comportamiento.reto_6.modelo.Prioridad;

public class TecnicoBasico extends Tecnico {
    
    public TecnicoBasico() {
        super("Técnico Básico");
    }
    
    @Override
    protected boolean puedeResolver(Ticket ticket) {
        return ticket.getNivel() == NivelDificultad.BASICO && 
               (ticket.getPrioridad() == Prioridad.BAJA || 
                ticket.getPrioridad() == Prioridad.MEDIA);
    }
}