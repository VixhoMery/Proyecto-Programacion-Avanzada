
public class OrdenDeTrabajo {
    private Persona cliente;
    private String problema;
    private String diagnostico;
    private String fechaRecepcion;
    private String fechaEntregaEstimada;
    //Setter
    public void setCliente(Persona cc){
        cliente = cc;
    }
    public void setProblema(String problem){
        problema = problem;
    }
    public void setDiagnostico(String diag){
        diagnostico = diag;
    }
    public void setFechaRecepcion(String fechaR){
        fechaRecepcion = fechaR;
    }
    public void setFechaEntregaEstimada(String fechaR){
        fechaEntregaEstimada = fechaR;
    }

    //Getter
    public Persona getCliente(){
        return cliente;
    }
    public String getProblema(){
        return problema;
    }
    public String getDiagnostico(){
        return diagnostico;
    }
    public String getFechaRecepcion(){
        return fechaRecepcion;
    }
    public String getFechaEntregaEstimada(){
        return fechaEntregaEstimada;
    }
}
