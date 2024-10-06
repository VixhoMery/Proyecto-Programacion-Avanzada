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
        OrdenDeTrabajo orden = ordenes.get(0);
        System.out.println("Cliente: "+orden.getCliente().getNombre());
    }
    
    public int largo(){
        int largo = ordenes.size();
        return largo;
    }
    
    public boolean nombresIguales(String nombre, int i){
        OrdenDeTrabajo ordenActual = ordenes.get(i);
        Persona p = ordenActual.getCliente();
        String name = p.getNombre();
        return name.equals(nombre);
    }
    
    public void mostrarLista(){
        for (int i = 0; i < ordenes.size(); i++) {
            OrdenDeTrabajo orden = ordenes.get(i);
            Persona p = orden.getCliente();
            System.out.println("Nombre Cliente: "+p.getNombre());
            System.out.println("Rut: "+p.getRut());
            System.out.println("Correo: "+p.getCorreo());
            System.out.println("Direccion: "+p.getDireccion());
            System.out.println("Teléfono: "+p.getTelefono());
            System.out.println("Diagnóstico Asociado: "+orden.getDiagnostico());
            System.out.println(" ");
        }
    }
    
    public void eliminarODT(int posicion){
        ordenes.remove(posicion);
    }
    
    public void setEspecialización(String especial){
        especializacion = especial;
    }
    
    public OrdenDeTrabajo getODT(int posición){
        return ordenes.get(posición);
    }
    
    public String getEspecializacion(){
        return especializacion;
    }    
}
