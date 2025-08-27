package edu.dows.lab.creacional.reto_4.untitled.core;

public interface Command {
    void execute();
    void undo();
    String getDescription();
}