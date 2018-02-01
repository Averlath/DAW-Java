package org.mvpigs.dni;

public class check {
    private String DNI;
    private char letter;
    private char[] letters = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J',
                            'Z','S','Q','V','H','L','C','K', 'E'};
    
    public check(String DNI) {
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
        if (isNumeric(DNI)) {
            int number = Integer.parseInt(DNI);
            this.letter = letters[calculateRemaining(number)];
        } else {
            System.out.println("El formato del DNI no es correcto.");
        }
    }

    private int calculateRemaining(int sum) {
        return sum%(letters.length);
    }

    public static boolean isNumeric(String character) {
        try {
            Integer.parseInt(character);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}