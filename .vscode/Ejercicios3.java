import java.util.Scanner;

public class Ejercicios3 {
    public static void main(String[] args) {
        Producto productos[] = new Producto[1000];
        int total_productos = 0;
        
        String nombre;
        int codigo;
        String categoria;
        int cantidad;
        String precio;

        Scanner texto;
        String opcion;

        do {
            System.out.println("Elije una opcion");
            System.out.println("1. Crear nuevo cliente");
            System.out.println("2. Ver todos los clientes");
            System.out.println("0. Salir");
            texto = new Scanner(System.in);
            opcion = texto.nextLine();
            if (opcion.equals("1")) {
                System.out.println("Introduce el nombre del producto");
                texto = new Scanner(System.in);
                nombre = texto.nextLine();
                System.out.println("Introduce el codigo del producto");
                texto = new Scanner(System.in);
                codigo = texto.nextInt();
                System.out.println("Introduce la categoria del producto");
                texto = new Scanner(System.in);
                categoria = texto.nextLine();
                System.out.println("Introduce la cantidad del producto");
                texto = new Scanner(System.in);
                cantidad = texto.nextInt();
                System.out.println("Introduce el precio del producto");
                texto = new Scanner(System.in);
                precio = texto.nextLine();
                Producto nuevo = new Producto(nombre, codigo, categoria, cantidad, precio);
                productos[total_productos] = nuevo;
                total_productos++;
            } else if (opcion.equals("2")) {
                System.out.println("---------");
                System.out.println("La lista de productos");
                for (int i = 0; i < total_productos; i++) {
                    System.out.println(productos[i]);
                    System.out.println("---------");
                }
            } else {
                System.out.println("Has salido del menu");
            }
        } while (!opcion.equals("0"));
        texto.close();
    }
}