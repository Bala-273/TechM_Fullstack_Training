package manager;

import dao.ParkingDAO;
import model.Vehicle;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ParkingManager {
    private final ParkingDAO parkingDAO;
    private final Scanner scanner;

    public ParkingManager() {
        parkingDAO = new ParkingDAO();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n--- Parking Management System ---");
            System.out.println("1. Vehicle Check-In");
            System.out.println("2. Vehicle Check-Out");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleCheckIn();
                    break;
                case 2:
                    handleCheckOut();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void handleCheckIn() {
        System.out.print("Enter Owner Name: ");
        String ownerName = scanner.nextLine();
        System.out.print("Enter Vehicle Number: ");
        String vehicleNumber = scanner.nextLine();

        int slotId = parkingDAO.getAvailableSlot();
        if (slotId == -1) {
            System.out.println("No slots available.");
            return;
        }

        LocalDateTime entryTime = LocalDateTime.now();
        Vehicle vehicle = new Vehicle(vehicleNumber, ownerName, slotId, entryTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


        boolean success = parkingDAO.checkInVehicle(vehicle);
        if (success) {
            parkingDAO.updateSlotAvailability(slotId, false);
            System.out.println("Vehicle Checked In. Slot ID: " + slotId);
            System.out.println("Details:");
            System.out.println("Owner: "+ ownerName);
            System.out.println("Vehicle no: "+vehicleNumber);
            System.out.println("Slot ID: "+ slotId);
            System.out.println("Entry Time: "+ entryTime.format(formatter));
        } else {
            System.out.println("Failed to check in vehicle.");
        }
    }

    private void handleCheckOut() {
        System.out.print("Enter Vehicle Number to Check Out: ");
        String vehicleNumber = scanner.nextLine();

        LocalDateTime exitTime = LocalDateTime.now();
        Vehicle vehicle = parkingDAO.checkOutVehicle(vehicleNumber, exitTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        if (vehicle != null) {
            System.out.println("Vehicle Checked Out");
            System.out.println("Owner: " + vehicle.getOwnerName());
            System.out.println("Slot ID: " + vehicle.getSlotId());
            System.out.println("Entry Time: " + vehicle.getEntryTime().format(formatter));
            System.out.println("Exit Time: " + vehicle.getExitTime().format(formatter));
            System.out.println("Total Fee: ₹" + Math.round(vehicle.getFee()));
        } else {
            System.out.println("Vehicle already checked out.");
        }
    }
}
