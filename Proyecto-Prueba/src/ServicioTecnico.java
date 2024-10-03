import java.util.HashMap;

public class ServicioTecnico {
    public HashMap<String, Estante> estantes = new HashMap<>();

    public void agregarEstante(String diagnostico, Estante estante) {
        estantes.put(diagnostico, estante);
    }

    public boolean estaClave(String clave){
        return estantes.containsKey(clave);
    }

    public Estante objeto(String diagnostico){
        return estantes.get(diagnostico);
    }
}
