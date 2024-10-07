
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeerCSV {

    public String CrearArchivoNuevo() {
        String nombreArchivo = "archivo.csv";
        String rutaTemporal;

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo))) {
            System.out.println("Archivo creado exitosamente.");
            nombreArchivo = "archivo.csv";
            rutaTemporal = ".//archivo.csv";
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
            nombreArchivo = null;
            rutaTemporal = null;
        }
        return rutaTemporal;
    }

    public void eliminarOrden(String nombreEliminar) {
        //funcion que cree el documento
        String rutaTemporal = CrearArchivoNuevo();
        if(rutaTemporal == null){
            System.out.println("Archivo no encontrado!!");
        }
        
        // Ruta relativa al archivo CSV desde el directorio raíz del proyecto
        String rutaRelativa = ".//datosClientes.csv";

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

                orden.setFechaEntregaEstimada(diag.calcularFecha(campos[5]));

                if(!campos[0].equals(nombreEliminar)){
                    agregarDatosCsvTemporal(rutaTemporal, orden);
                }
            }
            
            //eliminar el csv original
            eliminarArchivo(rutaRelativa);
            
            //renombrar archivo temporal y pasa a ser og
            renombrar(rutaTemporal, rutaRelativa);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }
    }
    
       // Método para eliminar un archivo CSV
    public void eliminarArchivo(String rutaArchivo) {
            File archivo = new File(rutaArchivo);
            if (archivo.exists()) {
                if (archivo.delete()) {
                    System.out.println("El archivo ha sido eliminado exitosamente.");
                } else {
                    System.out.println("No se pudo eliminar el archivo.");
                }
            } else {
                System.out.println("El archivo no existe.");
            }
        }
    
    public void renombrar(String rutaActual, String rutaTemporal){
        // Archivo original
        File archivoOriginal = new File(rutaActual);
        
        // Archivo con el nuevo nombre
        File archivoNuevo = new File(rutaTemporal);

        // Verificamos si el archivo original existe
        if (archivoOriginal.exists()) {
            // Intentamos renombrar el archivo
            if (archivoOriginal.renameTo(archivoNuevo)) {
                System.out.println("El archivo ha sido renombrado exitosamente.");
            } else {
                System.out.println("No se pudo cambiar el nombre del archivo.");
            }
        } else {
            System.out.println("El archivo original no existe.");
        }
    }

    
    
    //método para renombrar el archivo
    public void renombrarArchivo(String rutaActual, String nuevoNombre) {
            File archivoActual = new File(rutaActual);
            File archivoNuevo = new File(archivoActual.getParent(), nuevoNombre);

            if (archivoActual.exists()) {
                if (archivoNuevo.exists()) {
                    archivoNuevo.delete(); // Elimina si ya existe
                }
                if (archivoActual.renameTo(archivoNuevo)) {
                    System.out.println("El archivo ha sido renombrado exitosamente.");
                } else {
                    System.out.println("No se pudo renombrar el archivo.");
                }
            } else {
                System.out.println("El archivo no existe.");
            }
        }

    
    //Método para cambiar la ruta del archivo
    public void moverArchivo(String rutaActual, String nuevaRuta) {
        File archivoActual = new File(rutaActual);
        File archivoNuevo = new File(nuevaRuta);

        if (archivoActual.exists()) {
            if (archivoActual.renameTo(archivoNuevo)) {
                System.out.println("El archivo ha sido movido exitosamente.");
            } else {
                System.out.println("No se pudo mover el archivo.");
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }
    
    public void agregarDatosCsvTemporal(String archivo, OrdenDeTrabajo orden) {

        try (FileWriter fw = new FileWriter(archivo, true); // true habilita el modo "append"
                 BufferedWriter bw = new BufferedWriter(fw); PrintWriter pw = new PrintWriter(bw);) {
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
            //sb.append("\"").append(orden.getFechaEntregaEstimada()).append("\"");
            //sb.append(System.lineSeparator());

            // Escribir la línea en el archivo CSV
            pw.print(sb.toString());
            System.out.println("Datos agregados correctamente al archivo CSV.");

        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo CSV.");
            e.printStackTrace();
        }
    }
    
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
            }

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }
    }

    public void mostrarMapa(MapaDiagnostico mapa) {
        String diag = "Reparación de teclado";
        ListaOrdenes lista = new ListaOrdenes();
        lista = mapa.objeto(diag);
        lista.mostrar();
    }

    public void agregarDatosCsv(String archivo, OrdenDeTrabajo orden) {

        try (FileWriter fw = new FileWriter(archivo, true); // true habilita el modo "append"
                 BufferedWriter bw = new BufferedWriter(fw); PrintWriter pw = new PrintWriter(bw);) {
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
            //sb.append("\"").append(orden.getFechaEntregaEstimada()).append("\"");
            //sb.append(System.lineSeparator());

            // Escribir la línea en el archivo CSV
            pw.print(sb.toString());

        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo CSV.");
            e.printStackTrace();
        }
    }

    public void eliminarLinea(String rutaArchivo, String nombreEliminar) {
        File archivoCSV = new File(rutaArchivo);
        List<String> lineasRestantes = new ArrayList<>();

        // Leer el archivo y almacenar las líneas que no queremos eliminar
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");  // Dividir por comas

                // Verificar si la línea tiene suficientes campos
                if (campos.length > 1) {  // Asegurarte de que la línea tiene al menos dos campos
                    // Compara el nombre a eliminar, usando trim para evitar problemas de espacios
                    if (!campos[0].trim().equalsIgnoreCase(nombreEliminar.trim())) {
                        lineasRestantes.add(linea);  // Si no es el nombre que queremos eliminar, la mantenemos
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        // Sobrescribir el archivo con las líneas que no fueron eliminadas
        if (!lineasRestantes.isEmpty()) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(archivoCSV))) {
                for (String linea : lineasRestantes) {
                    pw.println(linea);
                }
                System.out.println("Archivo sobrescrito exitosamente.");
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("No hay líneas restantes para escribir.");
        }
    }
}
