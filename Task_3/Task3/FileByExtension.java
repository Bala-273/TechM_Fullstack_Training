package Task_3;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class FileByExtension {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        System.out.print("Enter file extension: ");
        String extension = scanner.nextLine();

        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            FilenameFilter filter = (dir, name) -> name.endsWith(extension);
            File[] files = directory.listFiles(filter);

            if (files.length > 0) {
                System.out.println("Files with extension " + extension + ":");
                for (File file : files) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("No files found with the extension " + extension);
            }
        } else {
            System.out.println("Directory does not exist.");
        }
        scanner.close();
    }
}
