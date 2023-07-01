package models.ParkingSpots;

import models.Vehicle;
import models.VehicleType;

import java.util.UUID;

public abstract class ParkingSpot {
    private final UUID id;
    private Vehicle vehicle;
    private boolean available;
    private final VehicleType vehicleType;
    private final int price;

    public void parkVehicle(Vehicle vehicle) {
        this.setVehicle(vehicle);
        this.setAvailable(false);
    }
    public void removeVehicle() {
        this.setVehicle(null);
        this.setAvailable(true);
    }

    public ParkingSpot(boolean available, VehicleType vehicleType, int price){
        this.id = UUID.randomUUID();
        this.available = available;
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

}
