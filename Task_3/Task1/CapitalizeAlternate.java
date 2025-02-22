package Task_1;

import java.util.Scanner;

public class CapitalizeAlternate {
    public static String capitalizeAlternate(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = (i % 2 == 0) ? Character.toUpperCase(input.charAt(i)) : Character.toLowerCase(input.charAt(i));
            result.append(ch);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String userInput = scanner.nextLine();

        String result = capitalizeAlternate(userInput);
        System.out.println("Final Output: " + result);

        scanner.close();
    }
}
