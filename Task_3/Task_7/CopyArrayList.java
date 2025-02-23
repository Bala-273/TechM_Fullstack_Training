package Task_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CopyArrayList {
    public static void main(String[] args) {
        List<String> sourceList = new ArrayList<>();
        sourceList.add("Black");
        sourceList.add("White");
        sourceList.add("Grey");
        sourceList.add("Yellow");
        sourceList.add("Red");
        sourceList.add("Burgundy");

        List<String> destinationList = new ArrayList<>(sourceList.size());
        
        for (int i = 0; i < sourceList.size(); i++) {
            destinationList.add(null);
        }

        Collections.copy(destinationList, sourceList);

        System.out.println("Source List: " + sourceList);
        System.out.println("Destination List (After Copy): " + destinationList);
    }
}
