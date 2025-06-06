package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    static String url = "jdbc:mysql://localhost:3306/parking_db";
    static String username = "root";
    static String password = "1070";

    public static Connection getConnection(){
            Connection connection = null;

            try{
                connection = DriverManager.getConnection(url,username,password);
            } catch(SQLException e){
                System.out.println("Connection failed!");
                e.printStackTrace();
            }
            return connection;

    }
}


