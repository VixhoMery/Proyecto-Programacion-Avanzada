public class Diagnosticar {
    /*Recibe una orden de trabajo del menú, esta clase recibe el mapa con estantes.
     * Dentro del método organizar se verifica si el estante está en el mapa, si está
     * se agrega la orden de trabajo a la lista correspondiente, si no está se crea.
     */
    private ListaOrdenes lista = new ListaOrdenes();
    public void organizar(OrdenDeTrabajo orden, MapaDiagnostico mapa, String diagnostico){
        if(mapa.estaClave(diagnostico)){
            lista  = mapa.objeto(diagnostico);
            lista.agregarOrden(orden);
        }
        else{
            ListaOrdenes nuevoEstante = new ListaOrdenes();
            nuevoEstante.setEspecialización(diagnostico);
            mapa.agregarEstante(diagnostico, nuevoEstante);

        }
    }
    
    public String calcularFecha(String diagnostico){
        if(diagnostico.length()>= 18){
            return "14 días";
        }
        else{
            return "7 días";
        }
    }
}