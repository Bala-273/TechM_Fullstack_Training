package model;
import java.time.LocalDateTime;

public class Vehicle {
    private String vehicleNumber;
    private String ownerName;
    private int slotId;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double fee;

    public Vehicle(String vehicleNumber, String ownerName, int slotId, LocalDateTime entryTime){
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.slotId = slotId;
        this.entryTime = entryTime;
        this.exitTime = null;
        this.fee = 0.0;
    }

    public String getVehicleNumber(){
        return vehicleNumber;
    }
    public String getOwnerName(){
        return ownerName;
    }
    public int getSlotId(){
        return slotId;
    }
    public LocalDateTime getEntryTime(){
        return entryTime;
    }
    public LocalDateTime getExitTime(){
        return exitTime;
    }
    public void setExitTime(LocalDateTime exitTime){
        this.exitTime = exitTime;
    }
    public double getFee() {
        return fee;
    }
    public void setFee(double fee){
        this.fee = fee;
    }

}
