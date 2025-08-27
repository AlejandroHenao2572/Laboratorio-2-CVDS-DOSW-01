package core;

public interface Command {
    void execute();
    void undo();
    String getDescription();
}