package edu.dows.lab.creacional.reto_4.untitled.commands;

import core.Command;

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