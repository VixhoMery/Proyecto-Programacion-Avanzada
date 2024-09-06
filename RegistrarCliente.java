import java.util.Scanner;

public class RegistrarCliente {

    public static void registrarCliente(ServicioTecnico mapa, Scanner scanner) {
        Persona cliente = new Persona();
        OrdenDeTrabajo orden = new OrdenDeTrabajo();
        Diagnosticar problema = new Diagnosticar();

        System.out.println("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        cliente.setNombre(nombre);

        System.out.println("Ingrese el rut del cliente: ");
        String rut = scanner.nextLine();
        cliente.setRut(rut);

        System.out.println("Ingrese el correo del cliente: ");
        String correo = scanner.nextLine();
        cliente.setCorreo(correo);

        System.out.println("Ingrese el teléfono del cliente: ");
        String telefono = scanner.nextLine();
        cliente.setTelefono(telefono);

        // Actualización orden del cliente
        orden.setCliente(cliente);
        System.out.println("Testimonio del Cliente: ");
        String testimonio = scanner.nextLine();
        orden.setProblema(testimonio);

        System.out.println("Ingrese Diagnóstico: ");
        String diagnostico = scanner.nextLine();
        orden.setDiagnostico(diagnostico);
        
        problema.organizar(orden, mapa, diagnostico);
    }
}
