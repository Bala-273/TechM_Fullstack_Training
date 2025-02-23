package Task_7;

import java.util.LinkedList;

public class AppendToLinkedList {
    public static void main(String[] args) {
        LinkedList<String> colours = new LinkedList<>();
        colours.add("Black");
        colours.add("White");
        colours.add("Grey");
        colours.add("Yellow");
        colours.add("Red");
        colours.add("Burgundy");

        System.out.println("Original LinkedList: " + colours);

        colours.addLast("Purple");

        System.out.println("Updated LinkedList after appending: " + colours);
    }
}
