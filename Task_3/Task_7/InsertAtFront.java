package Task_7;

import java.util.LinkedList;

public class InsertAtFront {
    public static void main(String[] args) {
        LinkedList<String> colours = new LinkedList<>();
        colours.add("Black");
        colours.add("White");
        colours.add("Grey");
        colours.add("Yellow");
        colours.add("Red");
        colours.add("Burgundy");

        System.out.println("Original LinkedList: " + colours);

        colours.addFirst("Purple");

        System.out.println("LinkedList after inserting at the front: " + colours);
    }
}
