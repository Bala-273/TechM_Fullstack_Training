package Task_4;

public class ExceptionHandlingEx {
    public static void main(String[] args) {
        try {
            int result = divideNumbers(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: Division by zero is not allowed.");
        }

        System.out.println("Program continues after handling the exception.");
    }

    public static int divideNumbers(int a, int b) {
        return a / b;
    }
}