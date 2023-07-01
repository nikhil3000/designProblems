package services.ParkingSpotManager;

import models.ParkingSpots.ParkingSpot;

import java.util.List;

public class FourWheelerParkingSpotManager extends ParkingSpotManager{
    public FourWheelerParkingSpotManager(List<ParkingSpot> parkingSpotList) {
        super(parkingSpotList);
    }
}
