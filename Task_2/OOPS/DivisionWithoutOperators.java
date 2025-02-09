package task_2;
import java.util.Scanner;

public class DivisionWithoutOperators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter dividend: ");
        int dividend = scanner.nextInt();

        System.out.print("Enter divisor: ");
        int divisor = scanner.nextInt();

        if (divisor == 0) {
            System.out.println("Division by zero is not allowed.");
            return;
        }

        int quotient = 0;
        int remainder = Math.abs(dividend);
        int absDivisor = Math.abs(divisor);

        while (remainder >= absDivisor) {
            remainder -= absDivisor;
            quotient++;
        }

        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            quotient = -quotient;
        }

        if (dividend < 0) {
            remainder = -remainder;
        }

        System.out.println("Quotient: " + quotient);
        System.out.println("Remainder: " + remainder);

        scanner.close();
    }
}
