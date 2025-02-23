package Task_9;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CountStringByLetter {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "orange", "australia", "cherry", "austria", "bangalore", "chennai", "orangutan");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the starting letter: ");
        char letter = scanner.next().charAt(0);

        long count = words.stream()
                .filter(word -> word.startsWith(String.valueOf(letter)))
                .count();

        System.out.println("Number of words starting with '" + letter + "': " + count);
        scanner.close();
    }
}
