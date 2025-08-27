package edu.dows.lab.comportamiento.reto_7.commands;

import edu.dows.lab.comportamiento.reto_7.core.Command;

public class DoorOpenCommand implements Command {
    private boolean isOpen = false;

    @Override
    public void execute() {
        isOpen = true;
    }

    @Override
    public void undo() {
        isOpen = false;
    }

    @Override
    public String getDescription() {
        return isOpen ? "Puerta abierta" : "Puerta cerrada";
    }
}