package Feb18_JDBC;
import java.sql.*;
import java.util.Scanner;

public class JdbcTask {
    static String url = "jdbc:mysql://localhost:3306/ipldb";
    static String username = "root";
    static String password = "****";

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to JDBC CRUD operations!");
        System.out.println("This program will perform CRUD operations");

        try(Connection connection = DriverManager.getConnection(url,username,password)){
            createTable(connection);

            boolean exit = false;
            while (!exit){
                System.out.println("Choose an operation:");
                System.out.println("1. Insert Record (Statement)");
                System.out.println("2. Insert Record (PreparedStatement)");
                System.out.println("3. Update Record");
                System.out.println("4. Delete Record");
                System.out.println("5. Display Record");
                System.out.println("6. Exit");
                System.out.println("Choose your option");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice){
                    case 1:
                        insertRecordStatement(connection);
                        break;
                    case 2:
                        insertRecordPreparedStatement(connection, scanner);
                        break;
                    case 3:
                        updateRecord(connection, scanner);
                        break;
                    case 4:
                        deleteRecord(connection, scanner);
                        break;
                    case 5:
                        displayRecords(connection);
                        break;
                    case 6:
                        exit = true;
                        System.out.println("Exiting program...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 6.");
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        scanner.close();
    }
    public static void createTable(Connection connection) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS iplteams (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "team_name VARCHAR(50), " +
                "points DOUBLE)";
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(query);
            System.out.println("Table 'iplteams' created successfully.");
        }
    }

    // Insert a record using Statement
    public static void insertRecordStatement(Connection connection) throws SQLException {
        String query = "INSERT INTO iplteams (team_name, points) VALUES ('CSK', 20)";
        try (Statement stmt = connection.createStatement()) {
            int rows = stmt.executeUpdate(query);
            System.out.println(rows + " record(s) inserted using Statement.");
        }
    }

    // Insert a record using PreparedStatement
    public static void insertRecordPreparedStatement(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter team name: ");
        String team_name = scanner.nextLine();
        System.out.print("Enter points: ");
        double points = scanner.nextDouble();

        String query = "INSERT INTO iplteams (team_name, points) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, team_name);
            pstmt.setDouble(2, points);
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " record(s) inserted using PreparedStatement.");
        }
    }

    // Update a record using PreparedStatement
    public static void updateRecord(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter team name to update: ");
        String team_name = scanner.nextLine();
        System.out.print("Enter new points: ");
        double points = scanner.nextDouble();

        String query = "UPDATE iplteams SET points = ? WHERE team_name = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setDouble(1, points);
            pstmt.setString(2, team_name);
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " record(s) updated using PreparedStatement.");
        }
    }

    // Delete a record using Statement
    public static void deleteRecord(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter team name to delete: ");
        String team_name = scanner.nextLine();

        String query = "DELETE FROM iplteams WHERE team_name = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1,team_name);
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " record(s) deleted using PreparedStatement.");
        }
    }

    // Display all records using PreparedStatement
    public static void displayRecords(Connection connection) throws SQLException {
        String query = "SELECT * FROM iplteams";
        try (PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            System.out.println("\nIPL Teams:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Team_Name: " + rs.getString("team_name") + ", Points: " + rs.getDouble("points"));
            }
        }
    }
}

