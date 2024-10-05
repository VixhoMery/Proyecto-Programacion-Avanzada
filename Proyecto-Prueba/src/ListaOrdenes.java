import java.util.ArrayList;
/*Cada estante está relacionado al problema, es decir, a cada
*  departamento especializado por el tipo de problema
Por ahora no se está usando especialización*/

public class ListaOrdenes {
    private String especializacion;
    //Creando lista
    ArrayList<OrdenDeTrabajo> ordenes = new ArrayList<>();

    public void agregarOrden(OrdenDeTrabajo orden){
        ordenes.add(orden);
    }
    
    public void mostrar(){
        OrdenDeTrabajo orden = ordenes.getFirst();
        System.out.println("Cliente: "+orden.getCliente().getNombre());
    }

    public void setEspecialización(String especial){
        especializacion = especial;
    }

    public String getEspecializacion(){
        return especializacion;
    }    
}
