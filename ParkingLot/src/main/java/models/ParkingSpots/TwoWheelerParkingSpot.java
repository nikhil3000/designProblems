package models.ParkingSpots;

import models.Vehicle;
import models.VehicleType;

public class TwoWheelerParkingSpot extends ParkingSpot {

    public TwoWheelerParkingSpot(Vehicle vehicle, boolean available) {
        super(vehicle, available, VehicleType.TWO_WHEELER, 10);
    }

    public int getPrice() {
        System.out.println("Getting price from TwoWheelerParkingSpot");
        return this.getPrice();
    }
}
