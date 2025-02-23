package Task_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleElements {
    public static void main(String[] args) {
        List<String> colours = new ArrayList<>();
        colours.add("Black");
        colours.add("White");
        colours.add("Grey");
        colours.add("Yellow");
        colours.add("Red");
        colours.add("Burgundy");

        System.out.println("Original List: " + colours);

        Collections.shuffle(colours);

        System.out.println("Shuffled List: " + colours);
    }
}
