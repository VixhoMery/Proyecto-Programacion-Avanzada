import java.util.HashMap;

public class MapaDiagnostico {
    public HashMap<String, ListaOrdenes> estantes = new HashMap<>();

    public void agregarEstante(String diagnostico, ListaOrdenes estante) {
        estantes.put(diagnostico, estante);
    }

    public boolean estaClave(String clave){
        return estantes.containsKey(clave);
    }

    public ListaOrdenes objeto(String diagnostico){
        return estantes.get(diagnostico);
    }
}
