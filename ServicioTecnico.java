import java.util.HashMap;

public class ServicioTecnico {
    public HashMap<String, Estante> estantes = new HashMap<>();

    void agregarEstante(String diagnostico) {
        estantes.put(diagnostico, new Estante());
    }

    boolean estaClave(String clave){
        return estantes.containsKey(clave);
    }

    Estante objeto(String diagnostico){
        return estantes.get(diagnostico);
    }
}
