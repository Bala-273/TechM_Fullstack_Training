package Task_9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates{
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 1, 2, 2, 3, 4, 4, 7, 8, 8, 8, 99, 9, 6, 6, 7);

        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Unique Numbers: " + uniqueNumbers);
    }
}
