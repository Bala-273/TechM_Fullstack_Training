package Task_9;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MinMaxUsingStreams {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 15, 30, 15, 25, 40, 107, 90);

        Optional<Integer> maxNumber = numbers.stream().max(Integer::compareTo);
        Optional<Integer> minNumber = numbers.stream().min(Integer::compareTo);

        if (maxNumber.isPresent() && minNumber.isPresent()) {
            System.out.println("Maximum Number: " + maxNumber.get());
            System.out.println("Minimum Number: " + minNumber.get());
        } else {
            System.out.println("List is empty.");
        }
    }
}
