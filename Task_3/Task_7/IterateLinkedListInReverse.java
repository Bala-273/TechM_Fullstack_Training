package Task_7;

import java.util.LinkedList;
import java.util.ListIterator;

public class IterateLinkedListInReverse {
    public static void main(String[] args) {
        LinkedList<String> colours = new LinkedList<>();
        colours.add("Black");
        colours.add("White");
        colours.add("Grey");
        colours.add("Yellow");
        colours.add("Red");
        colours.add("Burgundy");

        ListIterator<String> iterator = colours.listIterator(colours.size());

        System.out.println("Iterating LinkedList in Reverse Order:");
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}
