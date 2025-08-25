package edu.dows.lab.comportamiento.reto_6.cadena;

import edu.dows.lab.comportamiento.reto_6.tecnicos.*;

public class CadenaResponsabilidadFactory {
    
    public static Tecnico crearCadenaCompleta() {
        Tecnico basico = new TecnicoBasico();
        Tecnico intermedio = new TecnicoIntermedio();
        Tecnico avanzado = new TecnicoAvanzado();
        
        basico.setSiguienteTecnico(intermedio);
        intermedio.setSiguienteTecnico(avanzado);
        
        return basico; 
    }
    
    public static Tecnico crearCadenaPersonalizada(String... tipos) {
        if (tipos.length == 0) {
            return crearCadenaCompleta();
        }
        
        Tecnico primero = null;
        Tecnico anterior = null;
        
        for (String tipo : tipos) {
            Tecnico tecnico = crearTecnico(tipo);
            
            if (primero == null) {
                primero = tecnico;
            } else {
                anterior.setSiguienteTecnico(tecnico);
            }
            anterior = tecnico;
        }
        
        return primero;
    }
    
    private static Tecnico crearTecnico(String tipo) {
        switch (tipo.toLowerCase()) {
            case "basico": return new TecnicoBasico();
            case "intermedio": return new TecnicoIntermedio();
            case "avanzado": return new TecnicoAvanzado();
            default: throw new IllegalArgumentException("Tipo de tecnico no valido: " + tipo);
        }
    }
}