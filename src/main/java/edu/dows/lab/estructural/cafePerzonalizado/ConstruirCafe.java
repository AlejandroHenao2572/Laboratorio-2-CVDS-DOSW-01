

import java.util.List;
import edu.dows.lab.estructural.CafePerzonalizado.ToppingManager;
import edu.dows.lab.estructural.CafePerzonalizado.InterfazUsuario;
import edu.dows.lab.estructural.CafePerzonalizado.Cafe;
import edu.dows.lab.estructural.CafePerzonalizado.CafeBase;
import edu.dows.lab.estructural.CafePerzonalizado.Topping;

public class ConstruirCafe {
    private ToppingManager toppingManager;
    private InterfazUsuario interfaz;

    public ConstruirCafe(ToppingManager toppingManager, InterfazUsuario interfaz) {
        this.toppingManager = toppingManager;
        this.interfaz = interfaz;
    }

    public Cafe crearCafe() {
        Cafe cafe = new CafeBase();
        List<Integer> seleccionados = interfaz.solicitarToppingsDisponibles(toppingManager);

        for (int opcion : seleccionados) {
            if (opcion == toppingManager.obtenerSiguienteId() + 1) { // opción agregar nuevo topping
                String nombreNuevo = interfaz.solicitarNuevoToppingNombre();
                double precioNuevo = interfaz.solicitarNuevoToppingPrecio();
                interfaz.sc.nextLine(); // limpiar buffer
                toppingManager.agregarTopping(nombreNuevo, precioNuevo);
                cafe = new Topping(cafe, nombreNuevo, precioNuevo);
            } else {
                int index = opcion - 1;
                String nombre = toppingManager.obtenerNombre(index);
                Double precio = toppingManager.obtenerPrecio(index);
                if (nombre != null && precio != null) {
                    cafe = new Topping(cafe, nombre, precio);
                } else {
                    System.out.println("Opción inválida: " + opcion);
                }
            }
        }
        return cafe;
    }
}
