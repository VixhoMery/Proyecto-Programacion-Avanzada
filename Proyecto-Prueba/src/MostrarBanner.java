public class MostrarBanner {
    public static void mostrarBanner() {
        System.out.println("             ======================");
        System.out.println("             ===Servicio Tecnico===");
        System.out.println("             ======================");
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

        // Limpiar pantalla
        try {
            Thread.sleep(2000);  // Pausa de 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Imprimir 80 líneas en blanco
        for (int i = 0; i < 80; i++) {
            System.out.println();
        }
    }
}
