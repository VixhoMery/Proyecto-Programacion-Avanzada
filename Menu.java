<<<<<<< HEAD
import java.util.*;
public class Menu {

    static Scanner leerDato = new Scanner (System.in);
=======
import java.util.Scanner;
public class Menu {

    static Scanner leerDato= new Scanner (System.in);
>>>>>>> Vicente

    public static void main(String arg[]){

        System.out.println("              ======================");
        System.out.println("              ===Servicio Tecnico===");
        System.out.println("              ======================");
        System.out.println("                     █████████");
        System.out.println("  ███████          ███▒▒▒▒▒▒▒▒███");
        System.out.println("  █▒▒▒▒▒▒█       ███▒▒▒▒▒▒▒▒▒▒▒▒▒███");
        System.out.println("   █▒▒▒▒▒▒█    ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██");
        System.out.println("    █▒▒▒▒▒█   ██▒▒▒▒▒██▒▒▒▒▒▒██▒▒▒▒▒███");
        System.out.println("     █▒▒▒█   █▒▒▒▒▒▒████▒▒▒▒████▒▒▒▒▒▒██");
        System.out.println("   █████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██");
        System.out.println("   █▒▒▒▒▒▒▒▒▒▒▒▒█▒▒▒▒▒▒▒▒▒█▒▒▒▒▒▒▒▒▒▒▒██");
        System.out.println(" ██▒▒▒▒▒▒▒▒▒▒▒▒▒█▒▒▒██▒▒▒▒▒▒▒▒▒▒██▒▒▒▒██");
        System.out.println("██▒▒▒███████████▒▒▒▒▒██▒▒▒▒▒▒▒▒██▒▒▒▒▒██");
        System.out.println("█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒█▒▒▒▒▒▒████████▒▒▒▒▒▒▒██");
        System.out.println("██▒▒▒▒▒▒▒▒▒▒▒▒▒▒█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██");
        System.out.println(" █▒▒▒███████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██");
        System.out.println(" ██▒▒▒▒▒▒▒▒▒▒████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒█");
        System.out.println("  ████████████   █████████████████\n");

        //Limpiar pantalla.
        try {
            Thread.sleep(4000);  // Pausa de 4 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Imprimir 50 líneas en blanco
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
<<<<<<< HEAD
        
       

        int opcion ; 

=======


        int opcion; 
>>>>>>> Vicente
        do{
            //Menu de opciones
            System.out.println("======================");
            System.out.println("==Ingrese una Opción==");
            System.out.println("======================");
            System.out.println("1) Registrar Cliente");
<<<<<<< HEAD
            System.out.println("2) Diagnostico");
            System.out.println("3) Fecha estimada de la entrega");
            System.out.println("4) Ver stock\n");
            System.out.println("5) Salir del programa\n");

            opcion = leerDato.nextInt(); 

            //Switch de casos posibles
            switch (opcion){

                case 1:
                    System.out.println("Seleccionaste la opcion 1");
                    break;

                case 2:
                    System.out.println("Seleccionaste la opcion 2");
                    break;

                case 3:
                    System.out.println("Seleccionaste la opcion 3");
                    break;
                
=======
            System.out.println("2) OPCION 2");
            System.out.println("3) OPCION 3");
            System.out.println("4) OPCION 4\n");
            System.out.println("5) Salir del programa\n");

            opcion = leerDato.nextInt(); 
            leerDato.nextLine();
            
            //Switch de casos posibles
            switch (opcion){
                case 1:
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

                    System.out.println("Ingrese el Teléfono del cliente: ");
                    String telefono = leerDato.nextLine();
                    cliente.setTelefono(telefono);
                    
                    orden.setCliente(cliente);
                    System.out.println("Testimonio del Cliente: ");
                    String testimonio = leerDato.nextLine();
                    orden.setProblema(testimonio);
                    
                    System.out.println("Ingrese Diagnóstico: ");
                    String diagnostico = leerDato.nextLine();
                    orden.setDiagnostico(diagnostico);
                    

                    break;
                case 2:
                    System.out.println("Seleccionaste la opcion 2");
                    
                    break;
                case 3:
                    System.out.println("Seleccionaste la opcion 3");
                    break;

>>>>>>> Vicente
                case 4:
                    System.out.println("Seleccionaste la opcion 4");
                    break;
                
                case 5:
                    break;    
                }
            }while(opcion != 5);
<<<<<<< HEAD

            System.out.println("Hasta Luego!!!");
        }
    }
=======
            System.out.println("Hasta Luego!!!");
        }
    }
>>>>>>> Vicente
