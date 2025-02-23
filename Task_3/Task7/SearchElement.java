package Task_7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchElement {
    public static void main(String[] args) {
        List<String> colours = new ArrayList<>();
        colours.add("Black");
        colours.add("White");
        colours.add("Grey");
        colours.add("Yellow");
        colours.add("Red");
        colours.add("Burgundy");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the element to search: ");
        String searchElement = scanner.next();

        if (colours.contains(searchElement)) {
            int index = colours.indexOf(searchElement);
            System.out.println(searchElement + " found at index: " + index);
        } else {
            System.out.println(searchElement + " not found in the list.");
        }
    }
}
