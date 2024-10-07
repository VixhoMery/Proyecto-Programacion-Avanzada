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
        
        //System.out.println("Ingrese la Dirección del cliente: ");
        String direccion = "direccion genérica"; //temporal
        cliente.setDireccion(direccion);

        //Actualización orden del cliente
        orden.setCliente(cliente);

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
            
            for(int i = 0; i < lista.largo();i++){
                if(lista.nombresIguales(nombre, i)){
                    lista.eliminarODT(i);
                    //csv.eliminarLinea(rutaCSV, nombre);
                    System.out.println("El cliente y su orden de trabajo han sido eliminados exitosamente!!");
                    break;
                }
            }
            System.out.println(" ");
        }
    }
    
    public void editarDato(int dato,MapaDiagnostico mapa, OrdenDeTrabajo orden){
        String datoIngresado;
        Diagnosticar d = new Diagnosticar();
        
        if(dato == 1){ //nombre
            Persona p = orden.getCliente();
            datoIngresado = p.getNombre();
            System.out.println("Dato del Cliente: " + datoIngresado);
            System.out.println("¿Cambiar dato del cliente?");
            System.out.println("Confirmar(y/n): ");
            String confirmacion = leerDato.nextLine();
            if(confirmacion.equals(confirmacion)){
                System.out.println("Ingrese Nuevo Dato: ");
                datoIngresado = leerDato.nextLine();
                p.setNombre(datoIngresado);
                System.out.println("Datos modificados exitosamente");
            }
            else {return;} 
        }
        
        if (dato == 2){ //rut
            Persona p = orden.getCliente();
            datoIngresado = p.getRut();
            System.out.println("Dato del Cliente: " + datoIngresado);
            System.out.println("¿Cambiar dato del cliente?");
            System.out.println("Confirmar(y/n): ");
            String confirmacion = leerDato.nextLine();
            if(confirmacion.equals(confirmacion)){
                System.out.println("Ingrese Nuevo Dato: ");
                datoIngresado = leerDato.nextLine();
                p.setRut(datoIngresado);
                System.out.println("Datos modificados exitosamente");
            }
            else {return;}  
        }
        
        if(dato == 3 ){
            Persona p = orden.getCliente();
            datoIngresado = p.getCorreo();
            System.out.println("Dato del Cliente: " + datoIngresado);
            System.out.println("¿Cambiar dato del cliente?");
            System.out.println("Confirmar(y/n): ");
            String confirmacion = leerDato.nextLine();
            if (confirmacion.equals(confirmacion)) {
                System.out.println("Ingrese Nuevo Dato: ");
                datoIngresado = leerDato.nextLine();
                p.setCorreo(datoIngresado);
                System.out.println("Datos modificados exitosamente");
            } else {
                return;
            }
        }
        
        if(dato == 4){
            Persona p = orden.getCliente();
            datoIngresado = p.getDireccion();
            System.out.println("Dato del Cliente: " + datoIngresado);
            System.out.println("¿Cambiar dato del cliente?");
            System.out.println("Confirmar(y/n): ");
            String confirmacion = leerDato.nextLine();
            
            if (confirmacion.equals(confirmacion)) {
                System.out.println("Ingrese Nuevo Dato: ");
                datoIngresado = leerDato.nextLine();
                p.setDireccion(datoIngresado);
                System.out.println("Datos modificados exitosamente");
            } else {
                return;
            }
            
        }
        
        if(dato == 5){
            Persona p = orden.getCliente();
            datoIngresado = p.getTelefono();
            System.out.println("Dato del Cliente: " + datoIngresado);
            System.out.println("¿Cambiar dato del cliente?");
            System.out.println("Confirmar(y/n): ");
            String confirmacion = leerDato.nextLine();
            if (confirmacion.equals(confirmacion)) {
                System.out.println("Ingrese Nuevo Dato: ");
                datoIngresado = leerDato.nextLine();
                p.setTelefono(datoIngresado);
                System.out.println("Datos modificados exitosamente");
            } else {
                return;
            }
        }
        
        if(dato == 6){
            String datoActual = orden.getDiagnostico();
            System.out.println("Dato del Cliente: " + datoActual);
            System.out.println("¿Cambiar dato del cliente?");
            System.out.println("Confirmar(y/n): ");
            String confirmacion = leerDato.nextLine();
            if (confirmacion.equals(confirmacion)) {
                System.out.println("Ingrese Nuevo Dato: ");
                datoIngresado = leerDato.nextLine();
                orden.setDiagnostico(datoIngresado);
                d.organizar(orden, mapa, datoIngresado);
                System.out.println("Datos modificados exitosamente");
            } else {
                return;
            }
        }
    }    
}