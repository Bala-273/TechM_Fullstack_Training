package Task_3;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class LastModifiedDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);
        if (file.exists()) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            System.out.println("Last Modified Date: " + sdf.format(file.lastModified()));
        } else {
            System.out.println("The file does not exist.");
        }
        scanner.close();
    }
}
