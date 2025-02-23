package Task_4;

import java.io.*;
import java.util.*;

class PositiveNumberException extends Exception {
    public PositiveNumberException(String message) {
        super(message);
    }
}

public class ReadNegativeNumbers {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\sathi\\numbers.txt";

        try {
            List<Integer> numbers = readNumbersFromFile(filePath);
            System.out.println("All numbers in the file are negative or zero: " + numbers);
        } catch (PositiveNumberException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }

    public static List<Integer> readNumbersFromFile(String filePath) throws IOException, PositiveNumberException {
        List<Integer> numbers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            try {
                int num = Integer.parseInt(line.trim());
                if (num > 0) {
                    reader.close();
                    throw new PositiveNumberException("Positive number found: " + num);
                }
                numbers.add(num);
            } catch (NumberFormatException e) {
                System.out.println("Skipping invalid number: " + line);
            }
        }

        reader.close();
        return numbers;
    }
}
