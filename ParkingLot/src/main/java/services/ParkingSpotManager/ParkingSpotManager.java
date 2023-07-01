package services.ParkingSpotManager;

import models.ParkingSpots.ParkingSpot;

import java.util.List;
import java.util.Optional;

public abstract class ParkingSpotManager {
    public List<ParkingSpot> parkingSpotList;

    public ParkingSpotManager(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }

    public Optional<ParkingSpot> findNearestSpot() {
        // TODO: Taking in entry gate as a parameter and find the nearest spot
        return parkingSpotList.stream().filter(ParkingSpot::isAvailable).findAny();
    }

    public boolean occupySpot(ParkingSpot parkingSpot) {
        Optional<ParkingSpot> optionalParkingSpot = parkingSpotList.stream().filter(spot -> parkingSpot.getId().equals(spot.getId())).findFirst();
        if(optionalParkingSpot.isPresent()) {
            optionalParkingSpot.get().parkVehicle(parkingSpot.getVehicle());
            return true;
        }
        return false;
    }

    public boolean freeSpot(ParkingSpot parkingSpot) {
        Optional<ParkingSpot> optionalParkingSpot = parkingSpotList.stream().filter(spot -> parkingSpot.getId().equals(spot.getId())).findFirst();
        optionalParkingSpot.ifPresent(ParkingSpot::removeVehicle);
        return true;
    }

}
