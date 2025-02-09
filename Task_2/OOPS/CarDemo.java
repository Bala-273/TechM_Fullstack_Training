package task_2;
class Car {
    private String make;
    private String model;
    private int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public void startEngine() {
        System.out.println("The engine of " + make + " " + model + " has started.");
    }
}

class ElectricCar extends Car {
    private int batteryRange;

    public ElectricCar(String make, String model, int year, int batteryRange) {
        super(make, model, year);
        this.batteryRange = batteryRange;
    }

    public void chargeBattery() {
        System.out.println("The battery is charging...");
    }

    @Override
    public void startEngine() {
        System.out.println("The electric car " + getMake() + " " + getModel() + " is now on.");
    }
}

public class CarDemo {
    public static void main(String[] args) {
        Car myCar = new Car("Toyota", "Camry", 2022);
        ElectricCar myElectricCar = new ElectricCar("Tesla", "Model 3", 2023, 300);
        ElectricCar myElectricCar2 = new ElectricCar("TATA","Punch",2020,250);

        Car[] cars = {myCar, myElectricCar,myElectricCar2};

        for (Car c : cars) {
            c.startEngine();
        }
    }
}
