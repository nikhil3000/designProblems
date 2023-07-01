package models.ParkingSpots;

import models.Vehicle;
import models.VehicleType;

public class FourWheelerParkingSpot extends ParkingSpot {

    public FourWheelerParkingSpot(Vehicle vehicle, boolean available) {
        super(vehicle, available, VehicleType.FOUR_WHEELER, 20);
    }

    public int getPrice() {
        System.out.println("Getting price from FourWheelerParkingSpot");
        return this.getPrice() + 10;
    }
}
