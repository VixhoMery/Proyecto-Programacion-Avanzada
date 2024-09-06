
import java.util.Scanner;
import java.io.IOException;
public class Menu {
    static Scanner leerDato = new Scanner(System.in);
    static ServicioTecnico mapa = new ServicioTecnico();

    public static void main(String[] args) {
        MostrarBanner.mostrarBanner();
        int opcion;

        do {
            MostrarMenu.mostrarMenu();
            opcion = leerDato.nextInt();
            leerDato.nextLine();

            switch (opcion) {
                case 1:
                    RegistrarCliente.registrarCliente(mapa);
                    break;
                case 2:
                    //realizarDiagnostico();
                    break;
                case 3:
                    //mostrarFechaEstimacion();
                    break;
                case 4:
                    //verStock();
                    break;
                case 5:
                    System.out.println("Adios!!!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }
    
    public static void esperarTeclaParaVolverAlMenu() throws IOException {
        System.out.println("Presiona cualquier tecla para volver al menú...");
        System.in.read();  // Lee un carácter del teclado
    }
    
}