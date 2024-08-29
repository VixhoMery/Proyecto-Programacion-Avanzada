import java.util.*;
public class Menu {

    static Scanner leerDato = new Scanner (System.in);

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
        
       

        int opcion ; 

        do{
            //Menu de opciones
            System.out.println("======================");
            System.out.println("==Ingrese una Opción==");
            System.out.println("======================");
            System.out.println("1) Registrar Cliente");
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
                
                case 4:
                    System.out.println("Seleccionaste la opcion 4");
                    break;
                
                case 5:
                    break;    
                }
            }while(opcion != 5);

            System.out.println("Hasta Luego!!!");
        }
    }