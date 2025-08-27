package edu.dows.lab.creacional.reto_4.untitled.core;

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