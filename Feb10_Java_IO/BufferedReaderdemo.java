package Java.Io_10_feb;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderdemo {
    public static void getInputUsingBufferedReader() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the input: ");
        String input = reader.readLine();
        System.out.println("The given input: " + input);
    }
    public static void main(String[] args) throws IOException{
        getInputUsingBufferedReader();
    }
}
