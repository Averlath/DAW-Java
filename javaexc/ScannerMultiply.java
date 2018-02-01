import java.util.Scanner;

public class ScannerMultiply {
    public static void main(String[] args) {
        Scanner text = new Scanner(System.in);
        System.out.println("Input first number: ");
        int num1 = text.nextInt();
        System.out.println("Input second number: ");
        int num2 = text.nextInt();
        text.close();
        System.out.println(num1 + "x" + num2 + "=" + num1*num2);
    }
}