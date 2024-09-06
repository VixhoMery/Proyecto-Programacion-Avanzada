import java.util.Scanner;

public class RegistrarCliente {
    static Scanner leerDato = new Scanner(System.in);

    public static void registrarCliente(ServicioTecnico mapa) {
        Persona cliente = new Persona();
        OrdenDeTrabajo orden = new OrdenDeTrabajo();
        Diagnosticar problema = new Diagnosticar();

        System.out.println("Ingrese el nombre del cliente: ");
        String nombre = leerDato.nextLine();
        cliente.setNombre(nombre);

        System.out.println("Ingrese el rut del cliente: ");
        String rut = leerDato.nextLine();
        cliente.setRut(rut);

        System.out.println("Ingrese el correo del cliente: ");
        String correo = leerDato.nextLine();
        cliente.setCorreo(correo);

        System.out.println("Ingrese el Telefono del cliente: ");
        String telefono = leerDato.nextLine();
        cliente.setTelefono(telefono);

        orden.setCliente(cliente);
        System.out.println("Testimonio del Cliente: ");
        String testimonio = leerDato.nextLine();
        orden.setProblema(testimonio);

        System.out.println("Ingrese Diagnóstico: ");
        String diagnostico = leerDato.nextLine();
        orden.setDiagnostico(diagnostico);
        

        problema.organizar(orden, mapa, diagnostico);
    }
}
