import java.util.HashMap;
import java.util.Scanner;

public class VerStock {
    private HashMap<String, Integer> stock;

    public VerStock() {
        stock = new HashMap<>();
        stock.put("pantallas", 10);
        stock.put("baterias", 5);
        stock.put("procesadores", 3);
        stock.put("teclados", 7);
        stock.put("ratones", 4);
    }

    public void verStock() {
        try (Scanner scanner = new Scanner(System.in)) { 
            System.out.print("Ingrese el nombre del ítem que desea consultar: ");
            String item = scanner.nextLine().toLowerCase();

            if (stock.containsKey(item)) {
                int cantidad = stock.get(item);
                if (cantidad > 0) {
                    System.out.println("Quedan " + cantidad + " " + item + " en stock.");
                } else {
                    System.out.println("El ítem " + item + " está agotado.");
                }
            } else {
                System.out.println("No trabajamos con la pieza " + item + ".");
            }
        } 
    }
}
