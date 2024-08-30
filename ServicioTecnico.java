import java.util.HashMap;

public class ServicioTecnico {
    public HashMap<String, Estante> estantes = new HashMap<>();

    void agregarEstante(String tipoTrabajo) {
        estantes.put(tipoTrabajo, new Estante());
    }

    void agregarOrden(String tipoTrabajo, OrdenDeTrabajo orden) {
        estantes.get(tipoTrabajo).agregarOrden(orden);
    }
}
