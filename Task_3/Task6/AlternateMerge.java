package Task_6;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class AlternateMerge {
    public static <T> List<T> mergeAlternately(List<T> list1, List<T> list2) {
        List<T> mergedList = new ArrayList<>();
        int size1 = list1.size();
        int size2 = list2.size();
        int maxSize = Math.max(size1, size2);

        for (int i = 0; i < maxSize; i++) {
            if (i < size1) {
                mergedList.add(list1.get(i));
            }
            if (i < size2) {
                mergedList.add(list2.get(i));
            }
        }
        return mergedList;
    }

    public static void main(String[] args) {
        List<Integer> intList1 = Arrays.asList(1, 8, 9, 7);
        List<Integer> intList2 = Arrays.asList(2, 4, 6, 8, 10);
        System.out.println("Merged Integer List: " + mergeAlternately(intList1, intList2));

        List<String> strList1 = Arrays.asList("apple", "banana", "cherry", "coconut");
        List<String> strList2 = Arrays.asList("date", "orange", "pineapple", "grape");
        System.out.println("Merged String List: " + mergeAlternately(strList1, strList2));
    }
}
