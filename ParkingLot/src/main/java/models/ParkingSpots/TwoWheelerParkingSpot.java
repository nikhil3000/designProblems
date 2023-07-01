package models.ParkingSpots;

import models.Vehicle;
import models.VehicleType;

public class TwoWheelerParkingSpot extends ParkingSpot {

    public TwoWheelerParkingSpot() {
        super(true, VehicleType.TWO_WHEELER, 10);
    }

    public int getPrice() {
        System.out.println("Getting price from TwoWheelerParkingSpot");
        return super.getPrice();
    }
}
