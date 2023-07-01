package factories;

import models.ParkingSpots.ParkingSpot;
import models.VehicleType;
import services.ParkingSpotManager.FourWheelerParkingSpotManager;
import services.ParkingSpotManager.ParkingSpotManager;
import services.ParkingSpotManager.TwoWheelerParkingSpotManager;

import java.util.List;

public class ParkingSpotManagerFactory {

    private final TwoWheelerParkingSpotManager twoWheelerParkingSpotManager;
    private final FourWheelerParkingSpotManager fourWheelerParkingSpotManager;

    public ParkingSpotManagerFactory(List<ParkingSpot> twoWheelerParkingSpotList, List<ParkingSpot> fourWheelerParkingSpotList) {
        this.twoWheelerParkingSpotManager = new TwoWheelerParkingSpotManager(twoWheelerParkingSpotList);
        this.fourWheelerParkingSpotManager = new FourWheelerParkingSpotManager(fourWheelerParkingSpotList);
    }

    public ParkingSpotManager getParkingSpotManagerByVehicleType (VehicleType vehicleType) {
        return switch (vehicleType) {
            case TWO_WHEELER -> twoWheelerParkingSpotManager;
            case FOUR_WHEELER -> fourWheelerParkingSpotManager;
        };
    }
}
