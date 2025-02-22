package Task_3;

import java.io.File;

public class ListFilesandDir {
    public static void main(String[] args) {
        File directory = new File("C:\\Users\\sathi");
        if (directory.exists() && directory.isDirectory()) {
            String[] fileList = directory.list();
            System.out.println("Files in " + directory.getAbsolutePath() + ":");
            for (String file : fileList) {
                System.out.println(file);
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}
