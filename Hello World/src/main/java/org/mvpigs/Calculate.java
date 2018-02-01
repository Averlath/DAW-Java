package org.mvpigs;

import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) {
        Scanner teclado;
        int opcion;

        do {
            System.out.println("Elije una opcion: ");
            System.out.println("\t1. Resistencia (R)");
            System.out.println("\t2. Intensidad (A)");
            System.out.println("\t3. Tension (V)");
            System.out.println("\t0. Salir");
            teclado = new Scanner(System.in);
            opcion = teclado.nextInt();
            if (opcion == 1) {
                System.out.print("\tValor Intensidad");
                teclado = new Scanner(System.in);
                int intensidad = teclado.nextInt();
                System.out.print("\tValor Tension");
                teclado = new Scanner(System.in);
                int tension = teclado.nextInt();
                int resistencia = getResistencia(tension, intensidad);
                System.out.println("\tEl valor de la Resistencia es: " + resistencia + "\t");
                teclado.close();
            } else if (opcion == 2) {
                System.out.print("\tValor Tension");
                teclado = new Scanner(System.in);
                int tension = teclado.nextInt();
                System.out.print("\tValor Resistencia");
                teclado = new Scanner(System.in);
                int resistencia = teclado.nextInt();
                int intensidad = getTension(tension, resistencia);
                System.out.println("\tEl valor de la Resistencia es: " + intensidad + "\t");
                teclado.close();
            } else if (opcion == 3) {
                System.out.print("\tValor Intensidad");
                teclado = new Scanner(System.in);
                int intensidad = teclado.nextInt();
                System.out.print("\tValor Resistencia");
                teclado = new Scanner(System.in);
                int resistencia = teclado.nextInt();
                int tension = getTension(intensidad, resistencia);
                System.out.println("\tEl valor de la Resistencia es: " + tension + "\t");
                teclado.close();
            } else if (opcion == 0) {
                System.out.println("RIP");
            }
        } while (opcion != 0);
        teclado.close();
    }
    public static int getIntensidad(int voltios, int ohms) {
        int intensidad = voltios/ohms;
        return intensidad;}
    public static int getResistencia(int amperes, int voltios) {
        int resistencia = voltios/amperes;
        return resistencia;
    }

    public static int getTension(int amperes, int ohms) {
        int tension = amperes * ohms;
        return tension;
    };
}