package Task_6;

import java.util.List;
import java.util.Arrays;

public class FindIndex {
    public static <T> int findFirstOccurrence(List<T> list, T target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(10, 20, 30, 40, 50, 30);
        System.out.println("Index of 30 in intList: " + findFirstOccurrence(intList, 30));
        System.out.println("Index of 100 in intList: " + findFirstOccurrence(intList, 100));

        List<String> strList = Arrays.asList("apple", "banana", "cherry", "banana", "date");
        System.out.println("Index of 'banana' in strList: " + findFirstOccurrence(strList, "banana"));
        System.out.println("Index of 'grape' in strList: " + findFirstOccurrence(strList, "grape"));
    }
}
