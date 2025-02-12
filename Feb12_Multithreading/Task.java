package Serialization_Deserialization;

import java.io.*;

class Employee implements Serializable {
    int eno;
    String ename;
    transient String email;

    // Constructor
    public Employee(int eno, String ename, String email) {
        this.eno = eno;
        this.ename = ename;
        this.email = email;
    }
}

public class Task {
    public static void main(String[] args) {
        try {

            Employee emp1 = new Employee(107, "Bala", "B@123");

            FileOutputStream fout = new FileOutputStream("f.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(emp1);
            out.flush();

            out.close();
            fout.close();
            System.out.println("Serialization successful");
        } catch (Exception e) {
            System.out.println("Error during serialization: " + e.getMessage());
        } try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("f.txt"));

            Employee e1 = (Employee) in.readObject();

            System.out.println("Deserialized Student: " + e1.eno + " " + e1.ename);

            in.close();
        } catch (Exception e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }
    }
}
