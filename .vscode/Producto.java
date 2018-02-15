public class Producto {
    String nombre;
    int codigo;
    String categoria;
    int cantidad;
    String precio;

    public Producto(String n, int cod, String cat, int can, String p) {
        nombre = n;
        codigo = cod;
        categoria = cat;
        cantidad = can;
        precio = p;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String n) {
        nombre = n;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int cod) {
        codigo = cod;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String cat) {
        categoria = cat;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int can) {
        cantidad = can;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String p) {
        precio = p;
    } 
    public String toString() {
        String datos = "";
        datos += "ID: " + codigo + "\nNombre del producto: " + nombre + "\nCategoria: " + categoria + "\nCantidad: " + cantidad + "\nPrecio: " + precio + "Euros";
        return datos;
    }
}
