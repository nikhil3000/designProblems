package models.ParkingSpots;

import models.Vehicle;
import models.VehicleType;

import java.util.UUID;

public abstract class ParkingSpot {
    private UUID id;
    private Vehicle vehicle;
    private boolean available;
    private VehicleType vehicleType;
    private int price;

    public void parkVehicle(Vehicle vehicle) {
        this.setVehicle(vehicle);
        this.setAvailable(true);
    }
    public void removeVehicle() {
        this.setVehicle(null);
        this.setAvailable(false);
    }

    public ParkingSpot(Vehicle vehicle, boolean available, VehicleType vehicleType, int price){
        this.available = available;
        this.vehicle = vehicle;
        this.vehicleType = vehicleType;
        this.price = price;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public boolean isAvailable() {
        return available;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getPrice() {
        return price;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
