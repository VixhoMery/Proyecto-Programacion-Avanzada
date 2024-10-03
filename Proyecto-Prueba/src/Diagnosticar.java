public class Diagnosticar {
    /*Recibe una orden de trabajo del menú, esta clase recibe el mapa con estantes.
     * Dentro del método organizar se verifica si el estante está en el mapa, si está
     * se agrega la orden de trabajo a la lista correspondiente, si no está se crea.
     */
    private Estante estante = new Estante();
    public void organizar(OrdenDeTrabajo orden, ServicioTecnico mapa, String diagnostico){
        if(mapa.estaClave(diagnostico)){
            estante  = mapa.objeto(diagnostico);
            estante.agregarOrden(orden);
        }
        else{
            Estante nuevoEstante = new Estante();
            nuevoEstante.setEspecialización(diagnostico);
            mapa.agregarEstante(diagnostico, nuevoEstante);

        }
    }
    
    public void calcularFecha(OrdenDeTrabajo orden){
        
    }
}