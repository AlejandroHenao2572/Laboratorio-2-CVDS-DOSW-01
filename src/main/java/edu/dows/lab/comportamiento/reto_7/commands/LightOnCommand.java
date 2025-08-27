package edu.dows.lab.comportamiento.reto_7.commands;

import edu.dows.lab.comportamiento.reto_7.core.Command;

public class LightOnCommand implements Command {
    private boolean isOn = false;

    @Override
    public void execute() {
        isOn = true;
    }

    @Override
    public void undo() {
        isOn = false;
    }

    @Override
    public String getDescription() {
        return isOn ? "Luz encendida" : "Luz apagada";
    }
}