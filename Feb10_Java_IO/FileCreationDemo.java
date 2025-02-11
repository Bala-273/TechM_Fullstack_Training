package Java.Io_10_feb;
import java.io.File;
import java.io.IOException;

public class FileCreationDemo {
    public static void main(String[] args){
        try{
            File folder = new File("files");
            if (!folder.exists()){
                folder.mkdir();
                System.out.println("Directory created successfully");
            }

            File file = new File("files", "abcfile1.txt");
            if (file.createNewFile()){
                System.out.println("File created successfully: " + file.getAbsolutePath());
            }
            else{
                System.out.println("File already exists");
            }
        }
            catch (IOException e){
                System.out.println("An error occurred while creating the file: " + e.getMessage());
            }
        }
    }

