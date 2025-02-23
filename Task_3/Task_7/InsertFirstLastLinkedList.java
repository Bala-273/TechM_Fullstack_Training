package Task_7;

import java.util.LinkedList;

public class InsertFirstLastLinkedList {
    public static void main(String[] args) {
        LinkedList<String> colours = new LinkedList<>();
        colours.add("Black");
        colours.add("Grey");
        colours.add("White");

        System.out.println("Original LinkedList: " + colours);

        colours.addFirst("Purple");

        colours.addLast("Yellow");

        System.out.println("LinkedList after inserting at first and last positions: " + colours);
    }
}
