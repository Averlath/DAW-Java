import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner text = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int num1 = text.nextInt();
        System.out.println("Enter the second number: ");
        int num2 = text.nextInt();
        System.out.println("Enter the third number: ");
        int num3 = text.nextInt();
        text.close();
        int total = num1+num2+num3;
        float average = total/3;
        System.out.println("The average is: " + average);
    }
}