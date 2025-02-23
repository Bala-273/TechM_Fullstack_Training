package Task_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortArrayList {
    public static void main(String[] args) {
        List<String> colours = new ArrayList<>();
        colours.add("Black");
        colours.add("White");
        colours.add("Grey");
        colours.add("Yellow");
        colours.add("Red");
        colours.add("Burgundy");

        System.out.println("Original List: " + colours);

        Collections.sort(colours);

        System.out.println("Sorted List (Ascending Order): " + colours);

        Collections.sort(colours, Collections.reverseOrder());

        System.out.println("Sorted List (Descending Order): " + colours);
    }
}
