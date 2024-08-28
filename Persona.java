public class Persona {
    private String nombre;
    private String rut;
    private String correo;
    private String direccion;

    //Setters
    public void setNombre(String name){
        nombre = name;
    }

    public void setRut(String rut){
        this.rut = rut;
    }

    public void setCorreo(String mail){
        correo = mail;
    }

    public void setDireccion(String adress){
        direccion = adress;
    }

    //Getters

    public String getNombre(){
        return nombre;
    }

    public String getRut(){
        return rut;
    }

    public String getCorreo(){
        return correo;
    }

    public String getDireccion(){
        return direccion;
    }
}
