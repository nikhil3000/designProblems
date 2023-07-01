package models.ParkingSpots;

import models.Vehicle;
import models.VehicleType;

public class FourWheelerParkingSpot extends ParkingSpot {

    public FourWheelerParkingSpot() {
        super(true, VehicleType.FOUR_WHEELER, 20);
    }

    public int getPrice() {
        System.out.println("Getting price from FourWheelerParkingSpot");
        return super.getPrice() + 10;
    }
}
