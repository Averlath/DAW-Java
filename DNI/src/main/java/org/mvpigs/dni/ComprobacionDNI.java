package org.mvpigs.dni;

public class ComprobacionDNI {
    public static void main(String[] args) {
        check checkDNI = new check("12345678");
        System.out.println("La letra del DNI es: " + checkDNI.getLetter() + ".");
    }
}