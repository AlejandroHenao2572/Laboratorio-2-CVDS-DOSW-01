
import java.util.*;
import java.util.stream.Collectors;

public class CafePersonalizadoApp {
    public static void main(String[] args) {
        InterfazUsuario interfaz = new InterfazUsuario();
        ToppingManager toppingManager = new ToppingManager();
        ConstruirCafe constructor = new ConstruirCafe(toppingManager, interfaz);

        int numCafes = interfaz.solicitarNumeroCafes();
        List<Cafe> cafes = new ArrayList<>();

        for (int i = 1; i <= numCafes; i++) {
            System.out.printf("Café %d:\n", i);
            Cafe cafe = constructor.crearCafe();
            cafes.add(cafe);
        }

        interfaz.mostrarResumen(cafes);
    }
}