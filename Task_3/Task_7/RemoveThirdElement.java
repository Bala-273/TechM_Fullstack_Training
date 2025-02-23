package Task_7;

import java.util.ArrayList;
import java.util.List;

public class RemoveThirdElement {
    public static void main(String[] args) {
        List<String> colours = new ArrayList<>();
        colours.add("Black");
        colours.add("White");
        colours.add("Grey");
        colours.add("Yellow");
        colours.add("Red");
        colours.add("Burgundy");

        System.out.println("Original List: " + colours);

        int indexToRemove = 2;
        colours.remove(indexToRemove);
        System.out.println("Updated List after removing the third element: " + colours);
    }
}

