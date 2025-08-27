// src/core/RemoteControl.java
package core;

import java.util.*;

public class RemoteControl {
    private final List<ActionRecord> history = new ArrayList<>();

    public void executeAction(String user, Command command, boolean undo) {
        command.execute();
        ActionRecord record = new ActionRecord(user, command);
        if (undo) {
            command.undo();
            record.undone = true;
        }
        history.add(record);
    }

    public void printSummary() {
        int idx = 1;
        for (ActionRecord record : history) {
            String actionDesc = getActionName(record.command);
            String execDesc = getExecDescription(record.command, actionDesc);
            System.out.println("Acción " + idx + " ejecutada por " + record.user + ": " + execDesc);
            if (record.undone) {
                String undoDesc = getUndoDescription(record.command, actionDesc);
                System.out.println("Acción " + idx + " deshecha: " + undoDesc);
            }
            System.out.println();
            idx++;
        }

        System.out.println("Historial completo");
        idx = 1;
        for (ActionRecord record : history) {
            String actionDesc = getActionName(record.command);
            System.out.print(idx + ": " + actionDesc + " - Usuario: " + record.user);
            if (record.undone) System.out.print(" (deshecha)");
            System.out.println();
            idx++;
        }

        System.out.println("\nInvestigando quién desconfiguró los electrodomésticos\n");
        Map<String, Integer> userActions = new LinkedHashMap<>();
        for (ActionRecord record : history) {
            userActions.put(record.user, userActions.getOrDefault(record.user, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : userActions.entrySet()) {
            System.out.println("Se detecta que " + entry.getKey() + " realizó " + entry.getValue() + " acción" + (entry.getValue() > 1 ? "es que alteraron la configuración." : "."));
        }
    }

    // Métodos auxiliares para descripciones personalizadas
    private String getActionName(Command cmd) {
        if (cmd.getClass().getSimpleName().equals("VolumeAdjustCommand")) {
            return "Ajustar volumen a " + ((commands.VolumeAdjustCommand)cmd).getVolume() + "%";
        }
        if (cmd.getClass().getSimpleName().equals("LightOnCommand")) return "Encender luz";
        if (cmd.getClass().getSimpleName().equals("DoorOpenCommand")) return "Abrir puerta";
        if (cmd.getClass().getSimpleName().equals("MusicPlayCommand")) return "Reproducir música";
        return cmd.getDescription();
    }

    private String getExecDescription(Command cmd, String actionName) {
        if (cmd.getClass().getSimpleName().equals("VolumeAdjustCommand")) {
            return "Volumen ajustado a " + ((commands.VolumeAdjustCommand)cmd).getVolume() + "%";
        }
        if (cmd.getClass().getSimpleName().equals("LightOnCommand")) return "Luz encendida";
        if (cmd.getClass().getSimpleName().equals("DoorOpenCommand")) return "Puerta abierta";
        if (cmd.getClass().getSimpleName().equals("MusicPlayCommand")) return "Música reproducida";
        return actionName;
    }

    private String getUndoDescription(Command cmd, String actionName) {
        if (cmd.getClass().getSimpleName().equals("VolumeAdjustCommand")) {
            return "Volumen regresado a 0%";
        }
        if (cmd.getClass().getSimpleName().equals("LightOnCommand")) return "Luz apagada";
        if (cmd.getClass().getSimpleName().equals("DoorOpenCommand")) return "Puerta cerrada";
        if (cmd.getClass().getSimpleName().equals("MusicPlayCommand")) return "Música detenida";
        return actionName;
    }
}