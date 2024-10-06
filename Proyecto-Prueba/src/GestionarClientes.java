import java.util.Scanner;

public class GestionarClientes {
    static Scanner leerDato = new Scanner(System.in);

    public void registrarCliente(MapaDiagnostico mapa, LeerCSV csv, String rutaCSV) {
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
        
        System.out.println("Ingrese la Dirección del cliente: ");
        String direccion = "direccion genérica"; //temporal
        cliente.setDireccion(direccion);

        //Actualización orden del cliente
        orden.setCliente(cliente);
        //System.out.println("Testimonio del Cliente: ");
        //String testimonio = leerDato.nextLine();
        //orden.setProblema(testimonio);

        System.out.println("Ingrese Diagnóstico: ");
        String diagnostico = leerDato.nextLine();
        orden.setDiagnostico(diagnostico);
        
        problema.organizar(orden, mapa, diagnostico);
        
        csv.agregarDatosCsv(rutaCSV,orden);
    }
    /*
    public void buscar(MapaDiagnostico mapa){
        System.out.println("Ingresar Diagnóstico: ");
        String diagnostico = leerDato.nextLine();
        if(!mapa.estaClave(diagnostico)){
            System.out.println("Diagnostico no encontrado."); //después hacer con try-catch
        }
        
        else{
            System.out.println("Ingrese el nombre del cliente con formato ^Nombre Apellido^: ");
            String nombre = leerDato.nextLine();
            ListaOrdenes lista = mapa.objeto(diagnostico);
            //lista.mostrarLista();
           
            for(int i = 0; i < lista.largo();i++){
                if(lista.nombresIguales(nombre, i)){
                    System.out.println("El cliente y su orden de trabajo han sido eliminados exitosamente!!");
                    break;
                }
            }
            System.out.println(" ");
            lista.mostrarLista();
        }
    }    
    */
    public OrdenDeTrabajo buscar(MapaDiagnostico mapa){
        System.out.println("Ingresar Diagnóstico: ");
        String diagnostico = leerDato.nextLine();
        if(!mapa.estaClave(diagnostico)){
            System.out.println("Diagnostico no encontrado."); //después hacer con try-catch
        }
        
        else{
            System.out.println("Ingrese el nombre del cliente con formato ^Nombre Apellido^: ");
            String nombre = leerDato.nextLine();
            ListaOrdenes lista = mapa.objeto(diagnostico);
            //lista.mostrarLista();
           
            for(int i = 0; i < lista.largo();i++){
                if(lista.nombresIguales(nombre, i)){
                    OrdenDeTrabajo orden = lista.getODT(i);
                    return orden;
                }
            }
        }        
        return null;
    }
    
    public void eliminarCliente(MapaDiagnostico mapa, LeerCSV csv, String rutaCSV){
        System.out.println("Ingresar Diagnóstico: ");
        String diagnostico = leerDato.nextLine();
        if(!mapa.estaClave(diagnostico)){
            System.out.println("Diagnostico no encontrado."); //después hacer con try-catch
        }
        
        else{
            System.out.println("Ingrese el nombre del cliente con formato ^Nombre Apellido^: ");
            String nombre = leerDato.nextLine();
            ListaOrdenes lista = mapa.objeto(diagnostico);
            lista.mostrarLista();
            
            for(int i = 0; i < lista.largo();i++){
                if(lista.nombresIguales(nombre, i)){
                    lista.eliminarODT(i);
                    csv.eliminarLinea(rutaCSV, nombre);
                    System.out.println("El cliente y su orden de trabajo han sido eliminados exitosamente!!");
                    break;
                }
            }
            System.out.println(" ");
            lista.mostrarLista();
        }
    }
    
    public void editarDato(){
        
    }
}