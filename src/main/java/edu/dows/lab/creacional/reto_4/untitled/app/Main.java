package app;

import core.*;
import commands.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
        Scanner sc = new Scanner(System.in);

        System.out.print("Número de acciones a registrar: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= n; i++) {
            System.out.println("\nAcción " + i + ":");
            System.out.print("Usuario: ");
            String user = sc.nextLine();

            System.out.println("Seleccione:\n1. Encender luz\n2. Abrir puerta\n3. Reproducir música\n4. Ajustar volumen");
            int opt = Integer.parseInt(sc.nextLine());
            Command cmd = null;

            if (opt == 1) cmd = new LightOnCommand();
            else if (opt == 2) cmd = new DoorOpenCommand();
            else if (opt == 3) cmd = new MusicPlayCommand();
            else if (opt == 4) {
                System.out.print("Ingrese valor (0-100): ");
                int vol = Integer.parseInt(sc.nextLine());
                cmd = new VolumeAdjustCommand(vol);
            }

            System.out.print("Deshacer acción? (sí/no): ");
            boolean undo = sc.nextLine().trim().equalsIgnoreCase("sí");

            remote.executeAction(user, cmd, undo);
        }

        System.out.println();
        remote.printSummary();
    }
}