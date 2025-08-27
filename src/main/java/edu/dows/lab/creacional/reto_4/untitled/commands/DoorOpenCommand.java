package commands;

import core.Command;

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