package task_2;

import java.util.Scanner;

public class ExceptionHandling {
    public static void processInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a number: ");
            double num = scanner.nextDouble();
            if (num == 0) {
                throw new ArithmeticException("Cannot divide by zero!");
            }
            System.out.println("Reciprocal: " + (1 / num));
        } catch (Exception e) {
            System.out.println("Invalid input! " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void main(String[] args) {
        processInput();
    }
}
