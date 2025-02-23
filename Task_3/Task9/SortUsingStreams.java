package Task_9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortUsingStreams {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "orange", "australia", "cherry", "austria", "bangalore", "chennai", "orangutan", "date");

        List<String> ascendingOrder = words.stream()
                .sorted()
                .collect(Collectors.toList());

        List<String> descendingOrder = words.stream()
                .sorted((s1, s2) -> s2.compareTo(s1))
                .collect(Collectors.toList());

        System.out.println("Ascending Order: " + ascendingOrder);
        System.out.println("Descending Order: " + descendingOrder);
    }
}
