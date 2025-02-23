package Task_7;

import java.util.LinkedList;

public class FirstLastOccurrence {
    public static void main(String[] args) {
        LinkedList<String> colours = new LinkedList<>();
        colours.add("Black");
        colours.add("White");
        colours.add("Grey");
        colours.add("Yellow");
        colours.add("Red");
        colours.add("Grey");

        System.out.println("LinkedList: " + colours);

        String searchElement = "Grey";

        int firstIndex = colours.indexOf(searchElement);
        int lastIndex = colours.lastIndexOf(searchElement);

        if (firstIndex != -1) {
            System.out.println("First occurrence of '" + searchElement + "' is at index: " + firstIndex);
            System.out.println("Last occurrence of '" + searchElement + "' is at index: " + lastIndex);
        } else {
            System.out.println("Element '" + searchElement + "' not found in the LinkedList.");
        }
    }
}
