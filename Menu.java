
import java.util.Scanner;
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
                    esperarEnterParaVolverAlMenu();  
                break;
                case 2:
                    //realizarDiagnostico();
                    esperarEnterParaVolverAlMenu();  
                    break;
                case 3:
                    //mostrarFechaEstimacion();
                    esperarEnterParaVolverAlMenu();  
                    break;
                case 4:
                    //verStock();
                    esperarEnterParaVolverAlMenu();  
                    break;
                case 5:
                    System.out.println("Adios!!!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    public static void esperarEnterParaVolverAlMenu() {
        System.out.println("Presiona Enter para volver al menú...");
        leerDato.nextLine();  // Espera a que el usuario presione Enter
    }
}
