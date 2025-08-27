package edu.dows.lab.comportamiento.reto_7.commands;

import edu.dows.lab.comportamiento.reto_7.core.Command;

public class VolumeAdjustCommand implements Command {
    private int volume;
    private int prevVolume = 0;

    public VolumeAdjustCommand(int volume) {
        this.volume = volume;
    }

    @Override
    public void execute() {
        prevVolume = 0;
    }

    @Override
    public void undo() {
        volume = 0;
    }

    @Override
    public String getDescription() {
        return volume > 0 ? "Volumen ajustado a " + volume + "%" : "Volumen regresado a 0%";
    }

    public int getVolume() {
        return volume;
    }
}