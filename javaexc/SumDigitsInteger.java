import java.util.Scanner;

public class SumDigitsInteger {
    public static void main(String[] args) {
        Scanner text = new Scanner(System.in);
        System.out.print("Input an integer: ");
        int num = text.nextInt();
        System.out.println("The sum of the digits is: " + sumDigits(num));
    }
    
    public static int sumDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}