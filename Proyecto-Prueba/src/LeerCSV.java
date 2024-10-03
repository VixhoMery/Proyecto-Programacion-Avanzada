
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeerCSV {

    public void leerArchivo(ServicioTecnico mapa) {
        // Ruta relativa al archivo CSV desde el directorio raíz del proyecto
        String rutaRelativa = "./datosClientes.csv";

        try (Scanner scanner = new Scanner(new File(rutaRelativa))) {

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] campos = linea.replace("\"", "").split(",");
                Persona cliente = new Persona();
                OrdenDeTrabajo orden = new OrdenDeTrabajo();
                Diagnosticar diag = new Diagnosticar();

                cliente.setNombre(campos[0]);
                cliente.setRut(campos[1]);
                cliente.setCorreo(campos[2]);
                cliente.setDireccion(campos[3]);
                cliente.setTelefono(campos[4]);
                
                orden.setCliente(cliente);
                orden.setDiagnostico(campos[5]);
                diag.organizar(orden, mapa, orden.getDiagnostico());
                

                System.out.println(cliente.getNombre());
                System.out.println(cliente.getRut());
                System.out.println(cliente.getCorreo());
                System.out.println(cliente.getDireccion());
                System.out.println(cliente.getTelefono());
                System.out.println(" ");
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }
    }
}

// public static void main(String[] args) {
//     String rutaArchivo = "data/archivo.csv"; // Ruta relativa a la carpeta "data"
//     try (Scanner scanner = new Scanner(new File(rutaArchivo))) {
//         while (scanner.hasNextLine()) {
//             String linea = scanner.nextLine();
//             // Procesar la línea
//             String[] campos = linea.split(",");
//             for (String campo : campos) {
//                 System.out.print(campo + " | ");
//             }
//             System.out.println();
//         }
//     } catch (FileNotFoundException e) {
//         e.printStackTrace();
//     }
    // }
