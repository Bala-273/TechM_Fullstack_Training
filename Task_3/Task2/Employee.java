package Task_2;
import java.util.Scanner;

public class Employee {
    private int empId;
    private String empName;
    private double sal;
    private int yearsOfExperience;

    public void setEmployeeDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        this.empId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Employee Name: ");
        this.empName = scanner.nextLine();

        System.out.print("Enter Monthly Salary: ");
        this.sal = scanner.nextDouble();

        System.out.print("Enter Years of Experience: ");
        this.yearsOfExperience = scanner.nextInt();
    }

    public void getEmployeeDetails() {
        System.out.println("\nEmployee Details:");
        System.out.println("ID: " + empId);
        System.out.println("Name: " + empName);
        System.out.println("Monthly Salary: " + sal);
        System.out.println("Annual Salary: " + (sal * 12));
        System.out.println("Years of Experience: " + yearsOfExperience);
    }

    public void getLoanEligibility() {
        double annualSalary = sal * 12;
        double loanAmount = 0;

        if (yearsOfExperience > 5) {
            if (annualSalary >= 1500000) {
                loanAmount = 700000;
            } else if (annualSalary >= 1000000) {
                loanAmount = 500000;
            } else if (annualSalary >= 600000) {
                loanAmount = 200000;
            }

            if (loanAmount > 0) {
                System.out.println("\nLoan Eligibility: Eligible for ₹" + loanAmount);
            } else {
                System.out.println("\nLoan Eligibility: Not eligible for a loan.");
            }
        } else {
            System.out.println("\nLoan Eligibility: Not eligible! Must have greater than 5 years of experience).");
        }
    }

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setEmployeeDetails();
        emp.getEmployeeDetails();
        emp.getLoanEligibility();
    }
}

