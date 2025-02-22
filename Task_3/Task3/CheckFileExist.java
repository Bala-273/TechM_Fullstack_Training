package Task_3;

import java.io.File;
import java.util.Scanner;

public class CheckFileExist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file/directory path: ");
        String path = scanner.nextLine();

        File file = new File(path);
        if (file.exists()) {
            System.out.println("The file/directory exists.");
        } else {
            System.out.println("The file/directory does not exist.");
        }
        scanner.close();
    }
}
