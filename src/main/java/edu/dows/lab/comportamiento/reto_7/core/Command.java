package edu.dows.lab.comportamiento.reto_7.core;

public interface Command {
    void execute();
    void undo();
    String getDescription();
}