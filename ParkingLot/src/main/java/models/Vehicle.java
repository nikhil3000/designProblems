package models;

import java.util.UUID;

public class Vehicle {
    private final UUID id;
    private final String regNo;
    private final VehicleType vehicleType;

    public UUID getId() {
        return id;
    }

    public String getRegNo() {
        return regNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle(String regNo, VehicleType vehicleType) {
        this.id =  UUID.randomUUID();
        this.regNo = regNo;
        this.vehicleType = vehicleType;
    }
}
