package Java.Io_10_feb;
import java.util.Scanner;

public class ScannerInput {
    public static void getInputUsingScanner(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the input string: ");
        String str = scanner.nextLine();
        System.out.println("Your entered string value: " + str);

        System.out.println("Enter the input integer: ");
        int intval = scanner.nextInt();
        System.out.println("Your entered integer: " + intval);

        System.out.println("Enter the input float: ");
        float floatval = scanner.nextFloat();
        System.out.println("Your entered float value: " + floatval);

        scanner.close();
    }

    public static void main(String[] args){
        getInputUsingScanner();
    }
}
