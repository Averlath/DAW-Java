/*
    1.- Solicita por teclado al usuario un número e indica si es positivo negativo o cero
    2.- Solicita al usuario tres números e indica el mayor el menor y el intermedio suponiendo que son diferentes entre los 3
    3.- Solicita al usuario dos números y muestra sus divisores comunes
    4.- Solicita al usuario nombres e insértalos en una lista de String hasta que introduzca la palabra fin, la cual no se incluirá
        tras eso le muestras cuántos nombres ha introducido
    5.- Solicita al usuario nombres y luego almacénalos en un HashMap cuya clave será la inicial y el contenido un arraylist de los 
        nombres que contengan esa letra como inicial 


*/
/* import java.util.Scanner;

public class Ejercicios {
    public static void main(String[] args) {
        Scanner texto = new Scanner(System.in);
        int numero = texto.nextInt();
        if (numero > 0) {
            System.out.println("Positivo.");
        } else if (numero < 0) {
            System.out.println("Negativo");
        } else {
            System.out.println("Cero");
        }
    }
} */

/*import java.util.Scanner;

public class Ejercicios {
    public static void main(String[] args) {
        System.out.println("Introduce el primer numero");
        Scanner texto = new Scanner(System.in);
        int numero1 = texto.nextInt();
        System.out.println("Introduce el segundo numero");
        Scanner texto2 = new Scanner(System.in);
        int numero2 = texto.nextInt();
        System.out.println("Introduce el tercer numero");
        Scanner texto3 = new Scanner(System.in);
        int numero3 = texto.nextInt();

        int mayor;
        int menor;
        int intermedio;

        if (numero1 > numero2 && numero1 > numero3) {
            mayor = numero1;
            if (numero2 > numero3) {
                menor = numero3;
                intermedio = numero2;
            } else {
                menor = numero2;
                intermedio = numero3;
            }
        } else if (numero2 > numero1 && numero2 > numero3) {
            mayor = numero2;
            if (numero1 > numero3) {
                menor = numero3;
                intermedio = numero1;
            } else {
                menor = numero1;
                intermedio = numero3;
            }
        } else {
            mayor = numero3;
            if (numero1 > numero2) {
                menor = numero2;
                intermedio = numero1;
            } else {
                menor = numero1;
                intermedio = numero2;
            }
        }
    }
}*/

/*3.- Solicita al usuario dos números y muestra sus divisores comunes*/

/*import java.util.Scanner;

public class Ejercicios {
    public static void main(String[] args) {
        Scanner texto1 = new Scanner(System.in);
        int numero1 = texto1.nextInt();
        Scanner texto2 = new Scanner(System.in);
        int numero2 = texto2.nextInt();

        int i = 0;

        while (i < numero1 && i < numero2) {
            if ((numero1 % i) == 0) {
                if ((numero2 % i) == 0) {
                    System.out.println(i);
                }
            }
            i++;
        }
    }
}*/

/*4.- Solicita al usuario nombres e insértalos en una lista de String hasta que introduzca la palabra fin, la cual no se incluirá
        tras eso le muestras cuántos nombres ha introducido*/

/*import java.util.Scanner;
import java.util.ArrayList;

public class Ejercicios {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<String>();

        Scanner texto;
        String nombre;

        do {
            System.out.print("Introduce un nombre: ");
            texto = new Scanner(System.in);
            nombre = texto.nextLine();
            if (!nombre.equals("fin")) {
                lista.add(nombre);
            }
        } while (!nombre.equals("fin")) ;
        System.out.println("Has insertado un total de "+lista.size()+" nombres");
    }
}*/

/*5.- Solicita al usuario nombres y luego almacénalos en un HashMap cuya clave será la inicial y el contenido un (arraylist de los 
        nombres que contengan esa letra como inicial) */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Ejercicios {
    public static void main(String[] args) {
        Scanner texto;
        String nombre;
        Map<String, String> map = new HashMap<>();
        ArrayList<String> lista = new ArrayList<String>();

        do {
            System.out.println("Introduce un nombre: ");
            texto = new Scanner(System.in);
            nombre = texto.nextLine();
            String first = nombre.substring(0,1);
            if (!nombre.equals("fin")) {
                map.put(first, nombre);
            }
        } while (!nombre.equals("fin"));
        texto.close();
        System.out.println(map);
    }
}

/*import java.util.Scanner;

public class Ejercicios {
    public static void main(String[] args) {
        String lista[] = new String[10];

        lista[0] = "Jose";
        lista[1] = "Juan";
        lista[2] = "Andres";
        lista[3] = "Juana";
        lista[4] = "Maria";
        lista[5] = "Jaume";
        lista[6] = "Marina";
        lista[7] = "Juanjo";
        lista[8] = "Valentin";
        lista[9] = "Dani";

        int total = 0;

        Scanner texto;
        String nombre;
        do {
            System.out.println("Introduce el nombre en la posicion " + total);
            texto = new Scanner(System.in);
            nombre = texto.nextLine();
            if (!nombre.equals("fin")) {
                lista[total] = nombre;
                total++;
            }
        } while (!nombre.equals("fin"));

        
        int i = 0;
        do {
            System.out.println("El nombre de la posicion " + i + "es: " + lista[i]);
            i++;
        } while (i < total);
    }
}*/