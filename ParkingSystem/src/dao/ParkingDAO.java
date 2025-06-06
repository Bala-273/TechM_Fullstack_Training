package dao;

import Database.ConnectDatabase;
import model.Vehicle;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParkingDAO {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public int getAvailableSlot() {
        String query = "SELECT slot_id FROM parking_slots WHERE is_available = TRUE LIMIT 1";
        try (Connection conn = ConnectDatabase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("slot_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean updateSlotAvailability(int slotId, boolean isAvailable) {
        String query = "UPDATE parking_slots SET is_available = ? WHERE slot_id = ?";
        try (Connection conn = ConnectDatabase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setBoolean(1, isAvailable);
            stmt.setInt(2, slotId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkInVehicle(Vehicle vehicle) {
        String query = "INSERT INTO parked_vehicles (vehicle_number, owner_name, slot_id, entry_time) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectDatabase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, vehicle.getVehicleNumber());
            stmt.setString(2, vehicle.getOwnerName());
            stmt.setInt(3, vehicle.getSlotId());
            stmt.setString(4, vehicle.getEntryTime().format(formatter));

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Vehicle checkOutVehicle(String vehicleNumber, LocalDateTime exitTime) {
        String selectQuery = "SELECT * FROM parked_vehicles WHERE vehicle_number = ? AND exit_time IS NULL";
        String updateQuery = "UPDATE parked_vehicles SET exit_time = ?, fee = ? WHERE vehicle_number = ?";
        Vehicle vehicle = null;

        try (Connection conn = ConnectDatabase.getConnection();
             PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {

            selectStmt.setString(1, vehicleNumber);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                int slotId = rs.getInt("slot_id");
                String ownerName = rs.getString("owner_name");
                LocalDateTime entryTime = LocalDateTime.parse(rs.getString("entry_time"), formatter);

                long durationMinutes = java.time.Duration.between(entryTime, exitTime).toMinutes();
                double fee = Math.max(20, (durationMinutes / 60.0) * 20);  // ₹20/hr, min ₹20

                try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                    updateStmt.setString(1, exitTime.format(formatter));
                    updateStmt.setDouble(2, fee);
                    updateStmt.setString(3, vehicleNumber);
                    updateStmt.executeUpdate();
                }

                updateSlotAvailability(slotId, true);

                vehicle = new Vehicle(vehicleNumber, ownerName, slotId, entryTime);
                vehicle.setExitTime(exitTime);
                vehicle.setFee(fee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicle;
    }
}
