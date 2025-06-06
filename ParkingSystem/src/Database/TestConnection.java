package Database;
import Database.ConnectDatabase;

public class TestConnection {
    public static void main(String[] args) {
        try {
            if (ConnectDatabase.getConnection() != null) {
                System.out.println("Database connected successfully!");
            } else {
                System.out.println("Failed to connect to database.");
            }
        } catch (Exception e) {
            System.out.println("Error while connecting to database.");
            e.printStackTrace();
        }
    }
}