package task_2;


final class FinalClass {
    final int finalVariable = 100;

    public final void finalMethod() {
        System.out.println("This is a final method in the FinalClass.");
    }

    public void display() {
        System.out.println("The final variable value is: " + finalVariable);
    }
}


public class FinalKeywordDemo {
    public static void main(String[] args) {
        FinalClass finalClass = new FinalClass();

        System.out.println("Accessing final variable: " + finalClass.finalVariable);

        finalClass.finalMethod();
    }
}