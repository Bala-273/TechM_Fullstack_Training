package Task_7;

import java.util.Iterator;
import java.util.LinkedList;

public class IterateLinkedList {
    public static void main(String[] args) {
        LinkedList<String> colours = new LinkedList<>();
        colours.add("Black");
        colours.add("White");
        colours.add("Grey");
        colours.add("Yellow");
        colours.add("Red");
        colours.add("Burgundy");

        System.out.println("Iterating LinkedList:");
        Iterator<String> iterator = colours.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
