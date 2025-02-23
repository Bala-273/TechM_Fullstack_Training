package Task_7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RetrieveElement {
    public static void main(String[] args) {
        List<String> colours = new ArrayList<>();
        colours.add("Black");
        colours.add("White");
        colours.add("Grey");
        colours.add("Yellow");
        colours.add("Red");
        colours.add("Burgundy");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the index value (0 to " + (colours.size()-1)+ "): ");
        int index = scanner.nextInt();


        if (index >= 0 && index < colours.size()) {
            System.out.println("Element at index " + index + ": " + colours.get(index));
        } else {
            System.out.println("Invalid index! Please enter a value between 0 and " + (colours.size() - 1));
        }
    }
}
