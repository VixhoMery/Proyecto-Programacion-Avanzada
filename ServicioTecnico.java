import java.util.HashMap;

public class ServicioTecnico {
    public HashMap<String, Estante> estantes = new HashMap<>();

    void agregarEstante(String diagnostico, Estante estante) {
        estantes.put(diagnostico, estante);
    }

    boolean estaClave(String clave){
        return estantes.containsKey(clave);
    }

    Estante objeto(String diagnostico){
        return estantes.get(diagnostico);
    }
}
