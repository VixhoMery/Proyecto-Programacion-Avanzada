
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class LeerCSV {

    public void leerArchivo(MapaDiagnostico mapa) {
        // Ruta relativa al archivo CSV desde el directorio raíz del proyecto
        String rutaRelativa = "./datosClientes.csv";

        try (Scanner scanner = new Scanner(new File(rutaRelativa))) {

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                
                // Reemplazar comillas y dividir la línea en campos
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

                // Calcular diagnóstico y fecha estimada
                diag.organizar(orden, mapa, orden.getDiagnostico());
                orden.setFechaEntregaEstimada(diag.calcularFecha(campos[5]));

                // Imprimir los datos
                System.out.println(cliente.getNombre());
                System.out.println(cliente.getRut());
                System.out.println(cliente.getCorreo());
                System.out.println(cliente.getDireccion());
                System.out.println(cliente.getTelefono());
                System.out.println(orden.getDiagnostico());
                System.out.println(orden.getFechaEntregaEstimada());
                System.out.println(" ");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }
    }

    public void mostrarMapa(MapaDiagnostico mapa){
        String diag = "Reparación de teclado";
        ListaOrdenes lista = new ListaOrdenes();
        lista = mapa.objeto(diag);
        lista.mostrar();
    }
    
    
    public void agregarDatosCsv(String archivo, OrdenDeTrabajo orden) {
        
    try(FileWriter fw = new FileWriter(archivo, true);  // true habilita el modo "append"
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);  )
    {
        // Construir la línea CSV con los getters y agregar comillas dobles
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator());
        sb.append("\"").append(orden.getCliente().getNombre()).append("\",");
        sb.append("\"").append(orden.getCliente().getRut()).append("\",");
        sb.append("\"").append(orden.getCliente().getDireccion()).append("\",");
        sb.append("\"").append(orden.getCliente().getCorreo()).append("\",");
        sb.append("\"").append(orden.getCliente().getTelefono()).append("\",");
        //sb.append("\"").append(orden.getProblema()).append("\",");
        sb.append("\"").append(orden.getDiagnostico()).append("\",");
        //sb.append("\"").append(orden.getFechaRecepcion()).append("\",");
        sb.append("\"").append(orden.getFechaEntregaEstimada()).append("\"");
        //sb.append(System.lineSeparator());
        
        
        // Escribir la línea en el archivo CSV
        pw.print(sb.toString());
        System.out.println("Datos agregados correctamente al archivo CSV.");
            
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo CSV.");
            e.printStackTrace();
        }
    }
}
