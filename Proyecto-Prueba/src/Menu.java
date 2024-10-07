import java.util.Scanner;

public class Menu {
    static Scanner leerDato = new Scanner(System.in);
    static MapaDiagnostico mapa = new MapaDiagnostico(); // Instancia de servicio técnico

    public static void main(String[] args) {
        MostrarBanner.mostrarBanner();  // Mostrar banner al iniciar
        MostrarMenu menus = new MostrarMenu();
        LeerCSV csv = new LeerCSV();
        String rutaCSV = "./datosClientes.csv";
        VerStock verStock = new VerStock(); // Instancia de VerStock
        GestionarClientes gestionCliente = new GestionarClientes();
        csv.leerArchivo(mapa);
        
        int opcion;

        do {
            menus.mostrarMenu();  // Mostrar el menú de opciones
            while (!leerDato.hasNextInt()) {  // Validar que la entrada sea un número
                System.out.println("Por favor, ingrese un número válido.");
                leerDato.next();  // Consumir la entrada incorrecta
            }
            opcion = leerDato.nextInt(); // Leer la opción ingresada
            leerDato.nextLine();  // Consumir el salto de línea (enter)

            switch (opcion) {
                case 1 -> {
                    
                    gestionCliente.registrarCliente(mapa,csv,rutaCSV);  // Registrar cliente
                    System.out.println("El cliente se registró con éxito!!!");
                    esperarEnterParaVolverAlMenu();  // Esperar antes de volver al menú
                }
                case 2 ->{
                    // eliminar (pendiente de implementar)
                    gestionCliente.eliminarCliente(mapa, csv, rutaCSV);
                    esperarEnterParaVolverAlMenu();
                }
                case 3 ->{ // Mostrar fecha estimada (pendiente de implementar)

                    OrdenDeTrabajo ordenActual = gestionCliente.buscar(mapa);
                    
                    System.out.println("El orden de los datos es: ");
                    System.out.println("-> 1: Nombre");
                    System.out.println("-> 2: Rut");
                    System.out.println("-> 3: Correo");
                    System.out.println("-> 4: Dirección");
                    System.out.println("-> 5: Numero");
                    System.out.println("-> 6: Diagnostico");
                    System.out.println("¿Que dato necesita editar?: ");
                    int opcionEditar = leerDato.nextInt();
                    leerDato.nextLine();//consumir el enter
                    switch(opcionEditar){
                        case 1 -> {gestionCliente.editarDato(1,mapa,ordenActual);}
                        case 2 -> {gestionCliente.editarDato(2,mapa,ordenActual);}
                        case 3 -> {gestionCliente.editarDato(3,mapa,ordenActual);}
                        case 4 -> {gestionCliente.editarDato(4,mapa,ordenActual);}
                        case 5 -> {gestionCliente.editarDato(5,mapa,ordenActual);}
                        case 6 -> {gestionCliente.editarDato(6,mapa,ordenActual);}
                        default -> {System.out.println("Opción no válida!!");}
                    }
                    
                    esperarEnterParaVolverAlMenu();
                }
                case 4 -> {
                    System.out.println("Ingrese el Diagnóstico: ");
                    String diag = leerDato.nextLine();
                    ListaOrdenes lista = mapa.objeto(diag);
                    lista.mostrarLista();
                    esperarEnterParaVolverAlMenu();
                }
                
                case 5 -> {
                        System.out.println("Adios!!!");  // Mensaje de despedida
                }
                
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);  // El bucle se repite hasta que la opción sea 5 (salir)
    }

    // Método para esperar que el usuario presione Enter antes de volver al menú
    public static void esperarEnterParaVolverAlMenu() {
        System.out.println("Presiona Enter para volver al menú...");
        leerDato.nextLine();  // Espera a que el usuario presione Enter
    }
    
}