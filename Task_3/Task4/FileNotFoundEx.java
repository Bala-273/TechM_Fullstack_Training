package Task_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileNotFoundEx {
    public static void main(String[] args) {
        try {
            readFile("example.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        System.out.println("Program continues after handling the exception.");
    }

    public static void readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);

        if (!file.exists()) {
            throw new FileNotFoundException("File " + fileName + " not found.");
        }

        Scanner scanner = new Scanner(file);
        System.out.println("File contents:");
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }
}
