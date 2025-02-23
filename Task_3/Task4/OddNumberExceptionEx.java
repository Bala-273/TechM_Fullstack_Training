package Task_4;

public class OddNumberExceptionEx {
    public static void main(String[] args) {
        try {
            checkEvenNumber(7);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        System.out.println("Program continues after exception handling.");
    }

    public static void checkEvenNumber(int num) {
        if (num % 2 != 0) {
            throw new IllegalArgumentException("Number " + num + " is odd, which is not allowed.");
        } else {
            System.out.println("Number " + num + " is even.");
        }
    }
}
