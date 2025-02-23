package Task_7;

import java.util.LinkedList;
import java.util.Scanner;

public class InsertAtSpecifiedPositionInLinkedList {
    public static void main(String[] args) {
        LinkedList<String> colours = new LinkedList<>();
        colours.add("Black");
        colours.add("White");
        colours.add("Grey");
        colours.add("Yellow");
        colours.add("Red");
        colours.add("Burgundy");

        System.out.println("Original LinkedList: " + colours);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the index value: ");
        int index = scanner.nextInt();

        System.out.println("Enter the new value: ");
        String newValue = scanner.next();

        if (index >= 0 && index <= colours.size()) {
            colours.add(index, newValue);
            System.out.println("LinkedList after inserting '" + newValue + "' at index " + index + ": " + colours);
        } else {
            System.out.println("Invalid index! Please enter a value between 0 and " + colours.size());
        }
    }
}
