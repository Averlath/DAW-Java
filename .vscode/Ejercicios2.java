/*

    Menú principal
    1.- Nuevo cliente
    2.- Ver clientes
    0.- Salir
    Opción: 


    Esto debe repetirse hasta que se introduzca el cero

    Los clientes son objetos de clase cliente que tienen nombre apellido y dni

    Deben guardarse en un array de hasta 1000 posiciones

    Cada vez que damos a nuevo cliente simplemente pide un nuevo cliente
    Si damos a ver clientes nos muestra una lista de clientes

*/

import java.util.Scanner;

public class Ejercicios2 {
    public static void main(String[] args) {
        Cliente clientes[] = new Cliente[1000];
        int total_clientes = 0;

        Scanner texto;
        String opcion;
        String nombre;
        String apellidos;
        String DNI;

        do {
            System.out.println("Elije una opcion: ");
            texto = new Scanner(System.in);
            opcion = texto.nextLine();
            if (opcion.equals("1")) {
                System.out.println("Introduce el nombre del cliente: ");
                texto = new Scanner(System.in);
                nombre = texto.nextLine();
                System.out.println("Introduce el apellido del cliente: ");
                texto = new Scanner(System.in);
                apellidos = texto.nextLine();
                System.out.println("Introduce el DNI del cliente: ");
                texto = new Scanner(System.in);
                DNI = texto.nextLine();
                Cliente nuevo = new Cliente(nombre, apellidos, DNI);
                clientes[total_clientes] = nuevo;
                total_clientes++;
            } else if (opcion.equals("2")) {
                for (int i = 0; i < total_clientes; i++) {
                    System.out.println(clientes[i]);
                }
            } else {
                System.out.println("Has salido del menu");
            }
        } while (!opcion.equals("0"));
        texto.close();
    }
}