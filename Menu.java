import java.util.Scanner;

public class Menu {
    static Scanner leerDato = new Scanner(System.in);
    static ServicioTecnico mapa = new ServicioTecnico(); // Instancia de servicio técnico

    public static void main(String[] args) {
        MostrarBanner.mostrarBanner();  // Mostrar banner al iniciar
        VerStock verStock = new VerStock(); // Instancia de VerStock
        int opcion;

        do {
            MostrarMenu.mostrarMenu();  // Mostrar el menú de opciones
            while (!leerDato.hasNextInt()) {  // Validar que la entrada sea un número
                System.out.println("Por favor, ingrese un número válido.");
                leerDato.next();  // Consumir la entrada incorrecta
            }
            opcion = leerDato.nextInt(); // Leer la opción ingresada
            leerDato.nextLine();  // Consumir el salto de línea (enter)

            switch (opcion) {
                case 1:
                    RegistrarCliente.registrarCliente(mapa);  // Registrar cliente
                    System.out.println("El cliente se registró con éxito!!!");
                    esperarEnterParaVolverAlMenu();  // Esperar antes de volver al menú
                    break;
                case 2:
                    // Realizar diagnóstico (pendiente de implementar)
                    esperarEnterParaVolverAlMenu();
                    break;
                case 3:
                    // Mostrar fecha estimada (pendiente de implementar)
                    esperarEnterParaVolverAlMenu();
                    break;
                case 4:
                    verStock.verStock();  // Llamar al método verStock
                    esperarEnterParaVolverAlMenu();  // Esperar antes de volver al menú
                    break;
                case 5:
                    System.out.println("Adios!!!");  // Mensaje de despedida
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);  // El bucle se repite hasta que la opción sea 5 (salir)
    }

    // Método para esperar que el usuario presione Enter antes de volver al menú
    public static void esperarEnterParaVolverAlMenu() {
        System.out.println("Presiona Enter para volver al menú...");
        leerDato.nextLine();  // Espera a que el usuario presione Enter
    }
}
