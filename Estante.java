import java.util.ArrayList;
/*Cada estante está relacionado al problema, es decir, a cada
 *  departamento especializado por el tipo de problema*/
public class Estante {
    private String especializacion;
    //Creando lista
    ArrayList<OrdenDeTrabajo> ordenes = new ArrayList<>();

    public void agregarOrden(OrdenDeTrabajo orden){
        ordenes.add(orden);
    }

    public void setEspecialización(String especial){
        especializacion = especial;
    }

    public String getEspecializacion(){
        return especializacion;
    }    
}
