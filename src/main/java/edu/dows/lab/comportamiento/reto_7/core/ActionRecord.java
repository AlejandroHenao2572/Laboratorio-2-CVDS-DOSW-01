package edu.dows.lab.comportamiento.reto_7.core;

public class ActionRecord {
    public final String user;
    public final Command command;
    public boolean undone;

    public ActionRecord(String user, Command command) {
        this.user = user;
        this.command = command;
        this.undone = false;
    }
}