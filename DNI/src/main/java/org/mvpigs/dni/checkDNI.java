package org.mvpigs.dni;

public class checkDNI {
    private String DNI;
    private char letter;
    private static char[] letters=TablaDNI.getTabla();
    
    public checkDNI(String DNI) {
        this.DNI = DNI;
        calculateLetter(DNI);
    }
    public char getLetter() {
        return this.letter = letter;
    }
    public void setLetter(String DNI) {
        this.DNI = DNI;
    }
    public String getDNI() {
        return DNI;
    }
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    private void calculateLetter(String DNI) {
        if (numeroValido()) {
            int number = Integer.parseInt(DNI);
            this.letter = letters[calculateRemaining(number)];
            System.out.println("La letra del DNI es: " + Character.toString(this.letter) + ".");
        } else {
            System.out.println("El formato del DNI no es correcto.");
        }
    }
    private int calculateRemaining(int numeroDNI) {
        return numeroDNI%(letters.length);
    }
    public boolean isNumeric() {
        try {
            Integer.parseInt(this.DNI);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
    public boolean esLengthCorrecta() {
        if (this.DNI.length() == 8) {
            return true;
        } else {
            return false;
        }
    }
    public boolean numeroValido() {
        if (isNumeric() && esLengthCorrecta()) {
            return true;
        } else {
            return false;
        }
    }
}