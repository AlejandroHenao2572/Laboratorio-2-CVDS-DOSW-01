package edu.dows.lab.comportamiento.reto_7.commands;

import edu.dows.lab.comportamiento.reto_7.core.Command;

public class MusicPlayCommand implements Command {
    private boolean isPlaying = false;

    @Override
    public void execute() {
        isPlaying = true;
    }

    @Override
    public void undo() {
        isPlaying = false;
    }

    @Override
    public String getDescription() {
        return isPlaying ? "Música reproducida" : "Música detenida";
    }
}