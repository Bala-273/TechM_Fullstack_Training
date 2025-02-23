package Task_7;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class IterateFromPosition {
    public static void main(String[] args) {
        LinkedList<String> colours = new LinkedList<>();
        colours.add("Black");
        colours.add("White");
        colours.add("Grey");
        colours.add("Yellow");
        colours.add("Red");
        colours.add("Burgundy");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the index value to iterate from: ");
        int startIndex = scanner.nextInt();

        if (startIndex >= 0 && startIndex < colours.size()) {
            ListIterator<String> iterator = colours.listIterator(startIndex);

            System.out.println("Iterating from index " + startIndex + ":");
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } else {
            System.out.println("Invalid index! Please enter a value between 0 and " + (colours.size() - 1));
        }
    }
}
