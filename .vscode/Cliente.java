public class Cliente {
    private String nombre;
    private String apellidos;
    private String DNI;

    public Cliente(String n, String a, String d) {
        DNI = d;
        nombre = n;
        apellidos = a;    
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String n) {
        nombre = n;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String a) {
        apellidos = a;
    }

    public String DNI () {
        return DNI;
    }

    public void setDNI(String d) {
        DNI = d;
    }

    public String toString() {
        String datos = "";
        datos += "< "+DNI+" > "+nombre+" "+apellidos;
        return datos;
    }
}